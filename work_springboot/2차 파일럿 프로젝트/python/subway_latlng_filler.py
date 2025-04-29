import json
import requests
import time

# 카카오 REST API 키
REST_API_KEY = '774a609bd35ea9c1f05dcdba8d48eebe'
HEADERS = {"Authorization": f"KakaoAK {REST_API_KEY}"}

# 파일 경로
INPUT_FILE = "subway_stations_gwangju.json"
OUTPUT_FILE = "subway_with_latlng_gwangju.json"

# 파일 읽기
with open(INPUT_FILE, "r", encoding="utf-8") as f:
    data = json.load(f)

result = {}

for station_name, info in data.items():
    query = f"{station_name}역"
    url = "https://dapi.kakao.com/v2/local/search/keyword.json"
    params = {"query": query}
    res = requests.get(url, headers=HEADERS, params=params)
    if res.status_code == 200:
        documents = res.json()["documents"]
        if documents:
            location = documents[0]
            latitude = float(location["y"])
            longitude = float(location["x"])
            result[station_name] = {
                "stationCode": info["stationCode"],
                "line": info["line"],
                "districtCode": info["districtCode"],
                "latitude": latitude,
                "longitude": longitude
            }
            print(f"✅ {station_name}: {latitude}, {longitude}")
        else:
            print(f"❌ {station_name} 검색 결과 없음")
    else:
        print(f"❗ {station_name} API 요청 실패, 상태코드 {res.status_code}")
    
    time.sleep(0.2)  # 카카오 API 과금방지용 딜레이

# 저장
with open(OUTPUT_FILE, "w", encoding="utf-8") as f:
    json.dump(result, f, ensure_ascii=False, indent=4)

print(f"완료! {OUTPUT_FILE} 저장됨")
