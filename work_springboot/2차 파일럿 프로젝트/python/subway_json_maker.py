import csv
import json

def csv_to_json(csv_file_path, json_file_path):
    subway_data = {}

    with open(csv_file_path, encoding='utf-8') as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            station = row['전철역명'].strip()  # '전철역명'
            station_code = row['전철역코드'].strip()  # '전철역코드'
            line = row['호선'].strip()  # '호선'
            # latitude = row['위도'].strip()
            # longitude = row['경도'].strip()

            subway_data[station] = {
                "x": 0,  # 좌표 초기화
                "y": 0,
                "stationCode": station_code,  # 전철역 코드 추가
                "line": line,  # 호선 추가
                "districtCode": "" , # 시군구코드 (필요 시 추가)
                # "latitude": latitude,
                # "longitude": longitude
            }  
            
    with open(json_file_path, 'w', encoding='utf-8') as jsonfile:
        json.dump(subway_data, jsonfile, ensure_ascii=False, indent=4)

    print(f"✅ 변환 완료: {json_file_path}")

# 사용 예시
if __name__ == "__main__":
    csv_file = "subway_list_daejeon.csv"  # 니 파일명
    json_file = "subway_stations_daejeon.json"
    csv_to_json(csv_file, json_file)
