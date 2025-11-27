# youtube_chat.py
import os
from googleapiclient.discovery import build
from dotenv import load_dotenv

load_dotenv()
YOUTUBE_API_KEY = os.getenv("YOUTUBE_API_KEY")
CHANNEL_ID = os.getenv("CHANNEL_ID")

youtube = build("youtube", "v3", developerKey=YOUTUBE_API_KEY)

def get_live_chat_id(channel_id):
    res = youtube.search().list(
        part="snippet",
        channelId=channel_id,
        eventType="live",
        type="video"
    ).execute()

    items = res.get("items", [])
    if not items:
        return None, None

    video_id = items[0]["id"]["videoId"]

    v = youtube.videos().list(
        part="liveStreamingDetails",
        id=video_id
    ).execute()

    live_details = v["items"][0].get("liveStreamingDetails", {})
    return live_details.get("activeLiveChatId"), video_id


def get_chat_messages(live_chat_id):
    response = youtube.liveChatMessages().list(
        liveChatId=live_chat_id,
        part="snippet,authorDetails",
        maxResults=200
    ).execute()

    return response.get("items", [])
