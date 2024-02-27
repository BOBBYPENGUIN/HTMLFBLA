var Graphics = function(xPos, yPos, scale, type){
    this.xPos = xPos;
    this.yPos = yPos;
    this.scale = scale;
    this.type = type;
    RED = 'rbg(255,0,0)'
}
var drawRedSqare = function(){
    return [[RED]*16]*16;
}
