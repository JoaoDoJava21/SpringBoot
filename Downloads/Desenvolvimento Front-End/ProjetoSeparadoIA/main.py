# main.py
import os, time
from dotenv import load_dotenv
from groq_client import groq_chat_completion
from youtube_chat import get_live_chat_id, fetch_messages
from tts_eleven import eleven_tts_save
from did_client import create_talk_job, poll_and_download
from obs_control import play_video_in_obs

load_dotenv()
CHANNEL_ID = os.getenv("CHANNEL_ID")
IMAGE_URL = os.getenv("AVATAR_IMAGE_URL", "https://seu_servidor.com/imagens/jesus.jpg")
POLL_INTERVAL = 4

processed = set()

SYSTEM_PROMPT = ("Você é um assistente respeitoso e religioso. Responda pedidos de leitura de salmos, "
                 "orações ou pedidos de conforto com empatia, respeito, e brevidade. Não gere discurso de ódio.")

def main_loop():
    live_chat_id, video_id = get_live_chat_id(CHANNEL_ID)
    if not live_chat_id:
        print("Nenhuma live ativa encontrada. Inicie a live no YouTube.")
        return

    next_page_token = None
    while True:
        res = fetch_messages(live_chat_id, page_token=next_page_token)
        next_page_token = res.get("nextPageToken")
        items = res.get("items", [])
        for m in items:
            msg_id = m["id"]
            if msg_id in processed:
                continue
            processed.add(msg_id)
            text = m["snippet"]["displayMessage"]
            author = m["authorDetails"]["displayName"]
            print(author, "->", text)
            lowered = text.lower()
            # gatilho simples
            if lowered.startswith("leia") or "salmo" in lowered:
                prompt = f"Usuário: {text}\n\nResponda em português, leia o salmo/pedido e faça uma pequena oração de despedida."
                resposta = groq_chat_completion(SYSTEM_PROMPT, prompt)
                print("IA:", resposta)
                audio_file = eleven_tts_save(resposta, out_path=f"audio_{msg_id}.mp3")
                # OBS: para D-ID normalmente precisa de um URL público do áudio; subir para um servidor ou usar endpoint de upload
                # Aqui eu assumo que D-ID aceita audio_url público; se não, ajuste para upload direto.
                audio_url = f"https://seu_servidor.com/audios/{os.path.basename(audio_file)}"
                job = create_talk_job(IMAGE_URL, audio_url)
                job_id = job.get("id")
                video_file = poll_and_download(job_id, out_file=f"video_{msg_id}.mp4")
                if video_file:
                    play_video_in_obs(scene_name="JesusScene", source_name="JesusMedia", file_path=os.path.abspath(video_file))
        time.sleep(POLL_INTERVAL)

if __name__ == "__main__":
    main_loop()
