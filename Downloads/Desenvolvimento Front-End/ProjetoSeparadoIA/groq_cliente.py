# groq_client.py
import os
import requests
from dotenv import load_dotenv

load_dotenv()
GROQ_API_KEY = os.getenv("GROQ_API_KEY")
GROQ_BASE = "https://api.groq.com/openai/v1"  # endpoint compatível OpenAI-style , usei o groq por conta que é gratuito

def groq_chat_completion(system_prompt, user_prompt, model="llama3-70b-1024"):
    url = f"{GROQ_BASE}/chat/completions"
    headers = {
        "Authorization": f"Bearer {GROQ_API_KEY}",
        "Content-Type": "application/json"
    }
    payload = {
        "model": model,
        "messages": [
            {"role": "system", "content": system_prompt},
            {"role": "user", "content": user_prompt}
        ],
        "max_tokens": 400,
        "temperature": 0.6
    }
    r = requests.post(url, headers=headers, json=payload, timeout=30)
    r.raise_for_status()
    js = r.json()
    # compat: extrair texto
    text = ""
    try:
        text = js["choices"][0]["message"]["content"]
    except Exception:
        # fallback para modelo Responses API
        text = js.get("output_text") or js.get("choices", [{}])[0].get("text", "")
    return text
