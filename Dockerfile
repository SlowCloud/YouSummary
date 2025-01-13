FROM python:3.9-slim AS builder
WORKDIR /app
COPY requirements.txt .
RUN pip install --no-cache-dir --target=/app/dependencies -r requirements.txt
COPY main.py .

FROM gcr.io/distroless/python3
WORKDIR /app
COPY --from=builder /app /app
ENTRYPOINT ["python3", "main.py"]
