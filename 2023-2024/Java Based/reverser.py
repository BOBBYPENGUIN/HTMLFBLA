text = """{
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, YELLO},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, YELLO},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, GREE5, GREE5},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, GREE5, GREE5, GREE5},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, GREE5, GREE5, GREE5, GREE5},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, GRAYY, GRAYY, GRAYY, GRAYY, GRAYY},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, GRAYY, GRAYY, GRAYY},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, GRAYY, GRAYY, GRAYY},
            {CLEAR, BROW2, BROW2, BROW2, BROW2, BROW2, BROW2, BROW2, BROW2, BROW2, BROW2, BROW2, BROW2, BROW2, BROW2, BROW2},
            {BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3},
            {BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3},
            {BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BLACK},
            {BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BLACK, LGRAY},
            {BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BLACK, LGRAY, GRAYY},
            {BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BROW3, BLACK, LGRAY, GRAYY, GRAYY}
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