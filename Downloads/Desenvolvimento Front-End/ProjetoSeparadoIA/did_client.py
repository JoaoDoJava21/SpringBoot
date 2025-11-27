# did_client.py
import os, time, requests
from dotenv import load_dotenv

load_dotenv()
DID_API_KEY = os.getenv("DID_API_KEY")
DID_BASE = "https://api.d-id.com"

def create_talk_job(image_url, audio_url):
    url = f"{DID_BASE}/v1/talks"
    headers = {"Authorization": f"Bearer {DID_API_KEY}", "Content-Type": "application/json"}
    payload = {
        "source_image_url": image_url,
        "script": [
            {"type":"audio", "audio_url": audio_url}
        ],
        "config": {"resolution": "720p"}
    }
    r = requests.post(url, headers=headers, json=payload, timeout=30)
    r.raise_for_status()
    return r.json()

def poll_and_download(job_id, out_file="final_video.mp4"):
    url = f"{DID_BASE}/v1/talks/{job_id}"
    headers = {"Authorization": f"Bearer {DID_API_KEY}"}
    for _ in range(60):
        r = requests.get(url, headers=headers, timeout=30)
        r.raise_for_status()
        j = r.json()
        if j.get("status") == "done":
            video_url = j["result"]["video_url"]
            r2 = requests.get(video_url, stream=True, timeout=60)
            r2.raise_for_status()
            with open(out_file, "wb") as f:
                for chunk in r2.iter_content(8192):
                    f.write(chunk)
            return out_file
        time.sleep(2)
    return None
