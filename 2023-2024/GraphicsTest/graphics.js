var Graphics = function(xPos, yPos, scale, type){
    this.xPos = xPos;
    this.yPos = yPos;
    this.scale = scale;
    this.type = type;
    RED = 'rbg(255,0,0)'
}
Graphics.prototype.getCoordinates = function(){
    
    for(var row = 0; row < 16; row++){
        for(var column = 0; column < 16; column++){

        }
    }
}
Graphics.prototype.drawRedSquare = function(){
    return [[RED]*16]*16;
}
