# obs_control.py
import os
from obswebsocket import obsws, requests as obs_requests
from dotenv import load_dotenv

load_dotenv()
OBS_HOST = os.getenv("OBS_HOST", "localhost")
OBS_PORT = int(os.getenv("OBS_PORT", "4444"))
OBS_PASSWORD = os.getenv("OBS_PASSWORD", "")

def play_video_in_obs(scene_name="JesusScene", source_name="JesusMedia", file_path="/full/path/to/final_video.mp4"):
    ws = obsws(OBS_HOST, OBS_PORT, OBS_PASSWORD)
    ws.connect()
    try:
        ws.call(obs_requests.SetCurrentScene(scene_name))
        # update source settings
        settings = {"local_file": file_path}
        ws.call(obs_requests.SetSourceSettings(source_name, settings))
        # start playback if media source supports it
        ws.call(obs_requests.PlayPauseMedia(source_name, False))
    finally:
        ws.disconnect()
