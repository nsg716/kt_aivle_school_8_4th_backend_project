#!/bin/bash
set -euo pipefail

APP_SERVICE="myapp"

# 서비스가 있으면 중지(없으면 무시)
if systemctl list-unit-files | grep -q "^${APP_SERVICE}\.service"; then
  systemctl stop "${APP_SERVICE}" || true
fi

# ✅ /opt/myapp/bookMS-*.jar 실행 중인 java 프로세스 종료
PID="$(pgrep -f "java.*-jar.*/opt/myapp/bookMS-.*\.jar" || true)"
if [[ -n "${PID}" ]]; then
  echo "Stopping PID=${PID}"
  kill -15 "${PID}" || true
  sleep 5
  if kill -0 "${PID}" 2>/dev/null; then
    echo "Force killing PID=${PID}"
    kill -9 "${PID}" || true
  fi
fi
