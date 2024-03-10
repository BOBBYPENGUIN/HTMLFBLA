
const canvas = document.querySelector('.myCanvas');
const width = canvas.width = window.innerWidth - 20;
const height = canvas.height = window.innerHeight - 20;
const ctx = canvas.getContext('2d');
//Background
ctx.fillStyle = 'rgb(255,255,255)';
ctx.fillRect(0, 0, width, height);
//Necessary Global Variables
var curX;
var curY;
var curKey;
var keys = [];
var theDate = new Date();
var startTime = theDate.getTime();
var mouseDown = false;
var clicked = false;
var keyDown = false;
var scale = 15;
var state = 0;
var curKeyLetter = String.fromCharCode(curKey).toLowerCase();
var pastKeyLetter = String.fromCharCode(curKey).toLowerCase();

//Class for functions that require long if statements
var UsefulFunctions = function(tester) {
  this.tester = tester;
}
UsefulFunctions.prototype.getTime = function() {
  var curDate = new Date();
  var curTime = curDate.getTime();
  return (curTime);
}
UsefulFunctions.prototype.resetGame = function() {
}

//Initializes the class
var usefulFunctions = new UsefulFunctions("test");
//Creates button class
var Button = function(buttonText, xPos, yPos, bWidth, bHeight) {
  this.buttonText = buttonText;
  this.xPos = xPos;
  this.yPos = yPos;
  this.bWidth = bWidth;
  this.bHeight = bHeight;
}
Button.prototype.checkHover = function() {
  if (curX > this.xPos && curX < this.xPos + this.bWidth && curY > this.yPos && curY < this.yPos + this.bHeight) {
    return (true);
  } else {
    return (false);
  }
}
Button.prototype.drawButton = function(isHovering) {
  if (isHovering) {
    ctx.fillStyle = "rgb(100, 100, 100)";
  } else {
    ctx.fillStyle = "rgb(200, 200, 200)";
  }
  ctx.fillRect(this.xPos, this.yPos, this.bWidth, this.bHeight);
  ctx.fillStyle = "rgb(255, 255, 255)";
  ctx.font = (this.bHeight / 2.1).toString() + "px georgia";
  ctx.fillText(this.buttonText, this.xPos + this.bWidth / 2, this.yPos + this.bHeight / 1.4);
  ctx.fillStyle = 'rgb(255,255,255)';
}
Button.prototype.checkClicked = function(isHovering, runFunc) {
  if (clicked && isHovering) {
    usefulFunctions.resetGame();
    if (this.buttonText == "Easy") {
      speed = height / speedMod / 100;
      state = 1;
    }
    if (this.buttonText == "Medium") {
      speed = height / speedMod / 75;
      state = 1;
    }
    if (this.buttonText == "Hard") {
      speed = height / speedMod / 50;
      state = 1;
    }
    if (this.buttonText == "About") {
      state = 4;
    }
    if (this.buttonText == "Instructions") {
      state = 3;
    }
    if (this.buttonText == "Leaderboard") {
		log = log.sort(usefulFunctions.sortArr);
		state = 5;
    }
  }
}
//var arrOfButtons = [new Button("Easy", width / 6, height * 3 / 9, width / 6, height / 9), new Button("Medium", width * 2.5 / 6, height * 3 / 9, width / 6, height / 9), new Button("Hard", width * 4 / 6, height * 3 / 9, width / 6, height / 9), new Button("About", width / 6, height * 5 / 9, width / 6, height / 9), new Button("Instructions", width * 2.5 / 6, height * 5 / 9, width / 6, height / 9), new Button("Leaderboard", width * 4 / 6, height * 5 / 9, width / 6, height / 9)]
// update mouse pointer coordinates
document.addEventListener("mousemove", (e) => {
  curX = e.pageX;
  curY = e.pageY;
});
//Listens for keypresses
document.addEventListener("keypress", (e) => {
  curKey = e.keyCode;
  keys[e.key] = true;
  curKeyLetter = String.fromCharCode(curKey).toLowerCase();
  keyDown = true;
});
document.addEventListener("keyup", (e) => {
  keys[e.key] = false;
  curKeyLetter = "aa";
  curKey = -1
  keyDown = false;
});
document.addEventListener("mousedown", (e) => {
  mouseDown = true;
});
document.addEventListener("mouseup", (e) => {
  mouseDown = false;
});
document.addEventListener("click", (e) => {
  clicked = true;
});
//Draws the lines and the keys
var drawGameBackground = function() {
  for(var row = 0; row < width/scale; row++){
    for(var column = 0; column < height/scale; height++){
      grass = new Graphics(row * scale, column * scale, scale, 5);
      drawTile(grass);
    }
  }
} //creates grass
var grass = []
//grass.push(new Graphics(200, 200, 5, 5))
for(var i = 0; i < 1; i++){
  var rowTiles = []
  for(var j = 0; j < 1; j++){
    rowTiles.push(new Graphics(i*50*16, j * 50*16, 50, 5))
  }
  grass.push(rowTiles)
}
var drawTile = function(tile){
  for(var row = 0; row < 16; row++){
    for(var column = 0; column < 16; column++){
      ctx.fillStyle = tile.getColors()[row][column];
      ctx.fillRect(tile.getCoordinates()[row][column][0], tile.getCoordinates()[row][column][1], tile.scale, tile.scale);
    }
  }
}
//var possiblePositions = [0, width/10, width*2/10, width*3/10, width*6/10, width*7/10, width*8/10, width*9/10]
var xPosition = 30;
var yPosition = 30;
var playerHead = new Graphics(xPosition, yPosition, scale, 2);
var torso = new Graphics(xPosition, yPosition+scale*16, scale, 3);
var playerHead2 = new Graphics(xPosition, yPosition, scale, 6);
var torso2 = new Graphics(xPosition, yPosition+scale*16, scale, 7);
var playerHead3 = new Graphics(xPosition, yPosition, scale, 8);
var torso3 = new Graphics(xPosition, yPosition+scale*16, scale, 9);
//var legs = new Graphics(xPosition, yPosition+scale*16*2, scale, 4);
var speed = 5;
var count = 0;
function draw() {
  ctx.fillStyle = "white";
  ctx.fillRect(0, 0, width, height);
  //if(count % 120 <= 30 || (count % 120 > 60 && count % 120 <= 90)){
    drawTile(playerHead2);
    drawTile(torso2);
  //} else if(count % 120 > 30 && count % 120 <= 60){
  //  drawTile(playerHead2);
  //  drawTile(torso2);
  //} else{
  //  drawTile(playerHead3);
  //  drawTile(torso3);
  //}

  

  
  if(keys["w"]){//W key
    playerHead.move(0, -speed);
    torso.move(0, -speed);
    legs.move(0,-speed);
  }
  if(keys["d"]){//D key
    playerHead.move(speed, 0);
    torso.move(speed, 0);
    legs.move(speed, 0);
  }
  if(keys["s"]){//S key
    playerHead.move(0, speed);
    torso.move(0, speed);
    legs.move(0, speed);
  }
  if(keys["a"]){//A Key
    playerHead.move(-speed, 0);
    torso.move(-speed, 0);
    legs.move(-speed, 0);
  }
  if(keyDown){
    console.log(curKey);
  }
  //var grass = new Graphics(140, 30, scale, 5);
  //drawTile(grass)
  if(clicked){
    console.log("Test1");
  }
  clicked = false;
  keyDown = false;
  count = count + 2;
  window.requestAnimationFrame(draw);
};
draw();
