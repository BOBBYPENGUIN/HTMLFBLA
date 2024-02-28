var Graphics = function(xPos, yPos, scale, type){
    this.xPos = xPos;
    this.yPos = yPos;
    this.scale = scale;
    this.type = type;
    RED = "rgb(255,0,0)"
    GREEN = "rgb(0,255,0)"
}
Graphics.prototype.getCoordinates = function(){
    var positions = []
    for(var row = 0; row < 16; row++){
        var rowContents = []
        for(var column = 0; column < 16; column++){
            rowContents.push([this.xPos + row * this.scale, this.yPos + column * this.scale])
        }
        positions.push(rowContents);
    }
    return positions;
}
Graphics.prototype.drawRedSquare = function(){
    var colors = [
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, GREEN, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED],
        [RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED, RED]
    ]
    return colors;
}
