# How to use

## Options
- `--save`
    - 파일을 저장합니다. 저장 경로는 `/app/summary`입니다.
    - 도커 활용 시 사용하는 것을 추천합니다.

## Docker

### 저장 없이 요약하기
```shell
docker run --rm \
  -e OPENAI_API_KEY=<your_openai_api_key> \
  youtube-summary:distroless "<유튜브_URL>"
```

### 요약 후 저장하기
```shell
docker run --rm \
  -e OPENAI_API_KEY=<your_openai_api_key> \
  -v $(pwd):/app/summaries \
  youtube-summary:distroless "<유튜브_URL>" --save
```

명령어를 실행한 디렉터리에서 파일이 생성됩니다. 볼륨이 자동으로 등록되므로, 주기적으로 `docker volume prune` 작업이 필요합니다.

```shell
docker run --rm \
  -e OPENAI_API_KEY=<your_openai_api_key> \
  -v <파일을 저장할 위치>:/app/summaries \
  youtube-summary:distroless "<유튜브_URL>" --save
```
저장 위치를 고정하고 싶다면, `<파일을 저장할 위치>` 문구를 지우고 저장 위치를 작성해주세요.

### alias 설정
```shell
OPENAI_API_KEY="<your openai api key>"
SUMMARY_SAVE_DIRECTORY="<summary save directory>"

alias youtube-summarize="docker run --rm -e OPENAI_API_KEY=${OPENAI_API_KEY} -v ${SUMMARY_SAVE_DIRECTORY}:/app/summaries youtube-summary:distroless"
```
위와 같이 `alias` 설정을 통해 간결하게 도커를 실행할 수 있습니다. `.bashrc`에 작성해도 되고, `youtube-summary.sh` 파일로 작성해도 됩니다. 쉘 스크립트로 작성 시에는 `alias`를 제거해주세요.

`.bashrc`에 작성 시, 터미널 재접속 없이 즉시 적용하고 싶다면 `source ~/.bashrc` 명령어를 실행해주세요.

```shell
youtube-summary <youtube url> [--save]
```
이제 위와 같이 명령어를 실행하면 됩니다.