# pip install selenium
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
# pip install pyperclip
import pyperclip
import time


# 브라우저 꺼짐 방지 옵션
chrome_options = Options()
chrome_options.add_experimental_option("detach",True)

# browser = webdriver.Chrome() # "./chromedriver.exe"
browser = webdriver.Chrome(options=chrome_options)

# 1. 네이버 이동하면서 창 닫힘
browser.get("http://naver.com")

# 2. 로그인 버튼 클릭
elem = browser.find_element(By.CLASS_NAME,"MyView-module__link_login___HpHMW")
elem.click()

# 3. id 입력
id = browser.find_element(By.CSS_SELECTOR,"#id")
id.click() # 텍스트박스 클릭

#텍스트를 복사
pyperclip.copy("wotjr402")
# 복사한 아이디를 텍스트박스에 붙여넣기 
browser.find_element(By.CSS_SELECTOR,"#id").send_keys(Keys.CONTROL, "v")

# 4. pw 입력
pw = browser.find_element(By.CSS_SELECTOR,"#pw")
pw.click() # 텍스트박스 클릭

#텍스트를 복사
pyperclip.copy("tjqgud402#")
# 복사한 패스워드를 텍스트박스에 붙여넣기 
browser.find_element(By.CSS_SELECTOR,"#pw").send_keys(Keys.CONTROL, "v")

# 5. 로그인 버튼 클릭
browser.find_element(By.ID,"log.login").click()

time.sleep(3)

# 6. 등록 안함
# register = browser.find_element(By.ID,"new.dontsave")
# register.click()

# 7. html 정보 출력
print(browser.page_source)

# 8. 브라우저 종료
browser.close()