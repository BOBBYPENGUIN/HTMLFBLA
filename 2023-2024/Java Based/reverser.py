text = """{
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, BLACK, BLACK, BLACK, BLACK, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, BLACK, DARKB, DARKB, DARKB, DARKB, BLACK, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, BLACK, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, DARKB, BLACK, CLEAR, CLEAR},
            {CLEAR, CLEAR, BLACK, DARKB, DARKB, DARKB, DARKB, SKINN, SKINN, SKINN, DARKB, DARKB, DARKB, BLACK, CLEAR, CLEAR},
            {CLEAR ,CLEAR ,BLACK ,DARKB ,DARKB ,SKINN ,SKINN ,SKINN ,SKINN ,SKINN ,SKINN ,DARKB ,DARKB ,BLACK ,CLEAR ,CLEAR},
            {CLEAR ,CLEAR ,BLACK ,DARKB ,SKINN ,BLACK ,BLACK ,SKINN ,SKINN ,BLACK ,BLACK ,SKINN ,DARKB ,BLACK ,CLEAR ,CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, SKINN, WHIT1, BROW1, SKINN, SKINN, BROW1, WHIT1, SKINN, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, SKINN, WHITE, BROWN, SKINN, SKINN, BROWN, WHITE, SKINN, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, SKINN, SKINN, SKINN, SKINN, SKINN, SKINN, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, CLEAR, CLEAR, BLACK, SKINN, SKINN, SKINN, SKINN, BLACK, CLEAR, CLEAR, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, CLEAR, BLACK, BLACK, CYANN, ROSEE, ROSEE, CYANN, BLACK, BLACK, CLEAR, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, CLEAR, BLACK, GRAYY, GRAYY, GRAYY, REDDD, REDDD, GRAYY, GRAYY, GRAYY, BLACK, CLEAR, CLEAR, CLEAR},
            {CLEAR, CLEAR, BLACK, GRAYY, GRAYY, GRAYY, GRAYY, BLACK, BLACK, GRAYY, GRAYY, GRAYY, GRAYY, BLACK, CLEAR, CLEAR},
            {CLEAR, CLEAR, BLACK, GRAYY, BLACK, GRAYY, GRAYY, REDDD, REDDD, GRAYY, GRAYY, BLACK, GRAYY, BLACK, CLEAR, CLEAR},
            {CLEAR, CLEAR, BLACK, GRAYY, BLACK, GRAYY, GRAYY, REDDD, REDDD, GRAYY, GRAYY, BLACK, GRAYY, BLACK, CLEAR, CLEAR},
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