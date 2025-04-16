import re

p = re.compile("ca.e")

def print_match(m):
    if m:
        print("m.group() : ",m.group())#일치하는 문자열 반환=>care
        print("m.string : ",m.string)#입력받은 문자열 반환 => careless
        print("m.start() : ",m.start())# 일치하는 문자열의 시작 인덱스
        print("m.end() : ",m.end())# 일치하는 문자열의 끝 인덱스
        print("m.span() : ",m.span())# 일치하는 문자열의 시작과 끝 인덱스
    else:
        print("매칭되지 않음")

# m = p.match("careless")# match : 주어진 문자열의 처음부터 일치하는지 확인 
# m = p.search("good care")
# print_match(m)
lst = p.findall("good care cafe") # findall : 일치하는 모든 것을 리스트 형태로 반환 
print(lst)

# 1.match("careless")
# m.group() :  care
# m.string :  careless
# m.start() :  0
# m.end() :  4
# m.span() :  (0, 4)

# 2.match("good care")
# m.group() :  care
# m.string :  good care
# m.start() :  5
# m.end() :  9
# m.span() :  (5, 9)