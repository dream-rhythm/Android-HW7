import json

file = open('input.json', encoding='utf-8-sig')
data = json.loads(file.read())
file.close()
file = open('out.json', 'w', encoding='utf-8')
json.dump(data["Infos"]["Info"][0:10], file, indent=4,ensure_ascii=False)
file.close()
