#!/usr/bin/env bash
set -euo pipefail

JAVA_BIN="$(command -v java || true)"
if [[ -z "$JAVA_BIN" ]]; then
  echo "[ERROR] java not found in PATH: $PATH" >&2
  exit 127
fi

JAR="$(find /opt/myapp -maxdepth 1 -type f -name 'bookMS-*.jar' ! -name '*-plain.jar' | head -n 1)"

if [[ -z "$JAR" ]]; then
  echo "[ERROR] jar not found under /opt/myapp" >&2
  exit 1
fi

nohup "$JAVA_BIN" -jar "$JAR" > /var/log/myapp.log 2>&1 &
exit 0
