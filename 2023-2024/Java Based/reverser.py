text = """{
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, WHIT2},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, WHIT2, WHIT2},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, WHIT2, WHIT2, WHIT2},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, WHIT2, WHIT2, WHIT2, WHIT2},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, WHIT2, LBLUE, WHIT2, LBLUE, WHIT2, LBLUE},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, WHIT2, LBLUE, WHIT2, LBLUE, WHIT2, LBLUE},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, WHIT2, LBLUE, WHIT2, LBLUE, WHIT2, LBLUE},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, WHIT2, LBLUE, WHIT2, LBLUE, WHIT2, LBLUE},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2},
            {CLEAR, CLEAR, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2, WHIT2}
        }"""
text = text.replace("{", "")
text = text.replace("}", "")
text = text.replace(" ", "")
text = text.replace("\t", "")
textLine = text.split("\n")
newTextLine = []
for i in textLine:
    if(i != ""):
        arr = i.split(",")
        newArr = []
        for b in range(16):
            newArr.append(arr[15-b])
        newTextLine.append(newArr)

targetStr = "{"
for i in newTextLine:
    targetStr = targetStr + "\n{"
    for a in range(len(i)):
        targetStr = targetStr + i[a]
        if(a != 15):
            targetStr = targetStr + ", "
    targetStr = targetStr + "},"
targetStr = targetStr[0:-1] + "\n}"
print(targetStr)
input()