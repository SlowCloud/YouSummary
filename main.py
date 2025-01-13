import argparse
import json
import os
from langchain.document_loaders import YoutubeLoader
from langchain.chains.summarize import load_summarize_chain
from langchain.llms import OpenAI

def summarize_video(url, save=False, save_dir="./summaries"):
    # Step 1: Load YouTube video using LangChain's YoutubeLoader
    loader = YoutubeLoader.from_youtube_url(url)
    documents = loader.load()

    # Step 2: Use LangChain summarization chain
    llm = OpenAI(model="gpt-3.5-turbo", temperature=0.5)  # Replace with your LLM provider setup
    chain = load_summarize_chain(llm, chain_type="map_reduce")
    summary = chain.run(documents)

    print(f"Summary of the video:\n{summary}")

    if save:
        # Ensure the save directory exists
        os.makedirs(save_dir, exist_ok=True)

        # Extract video title for filename
        video_title = loader.metadata["title"].replace(" ", "_")
        filename = os.path.join(save_dir, f"{video_title}.json")
        
        # Save summary in JSON format
        with open(filename, "w", encoding="utf-8") as f:
            json.dump({"title": video_title, "url": url, "summary": summary}, f, ensure_ascii=False, indent=4)
        print(f"Summary saved to {filename}")

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Summarize YouTube video")
    parser.add_argument("url", type=str, help="YouTube video URL")
    parser.add_argument("--save", action="store_true", help="Save summary to a JSON file")

    args = parser.parse_args()
    summarize_video(args.url, args.save)
