import requests
res = requests.get("http://www.google.com")
res.raise_for_status() #에러가 있다면 멈춰주고 에러를 알려준다
print("응답코드 : ",res.status_code) #200 이면 정상

# print(len(res.text)) #17992
print(res.text) 