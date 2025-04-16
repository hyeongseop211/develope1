import requests
from bs4 import BeautifulSoup

url ="https://kin.naver.com/search/list.naver?query=%ED%8C%8C%EC%9D%B4%EC%8D%AC"

response = requests.get(url)

if response.status_code == 200 :
    html = response.text
    soup = BeautifulSoup(html,'html.parser') # lxml 파싱할때 사용 가능(pip install lxml)
    ul = soup.select_one("ul.basic1")
    titles = ul.select("li > dl > dt > a")
    for title in titles:
        print(title.get_text())
else:
    print(response.status_code)


