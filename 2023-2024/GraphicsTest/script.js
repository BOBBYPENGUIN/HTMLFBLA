
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
var theDate = new Date();
var startTime = theDate.getTime();
var mouseDown = false;
var clicked = false;
var keyDown = false;
var speed = height / 7 / 35;
var scoreMultiplier = 1.4;
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
  curKeyLetter = String.fromCharCode(curKey).toLowerCase();
  keyDown = true;
});
document.addEventListener("keyup", (e) => {
  curKeyLetter = "g";
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
  var redSquare = new Graphics(30, 30, 30, 1);
  var square = redSquare.drawRedSquare();
  for(var row = 0; row < 16; row++){
    for(var column = 0; column < 16; column++){
      ctx.fillStyle = redSquare.drawRedSquare()[row][column];
      ctx.fillRect(redSquare.getCoordinates()[row][column][0], redSquare.getCoordinates()[row][column[1]], redSquare.scale, redSquare.scale);
    }
  }
}
//var possiblePositions = [0, width/10, width*2/10, width*3/10, width*6/10, width*7/10, width*8/10, width*9/10]
function draw() {
  //ctx.fillStyle = "white";
  //ctx.fillStyle= "rgb(255,0,0)";
  //ctx.fillRect(200, 20, 20, 20);
  var whiteSquare = new Graphics(30, 30, 5, 1);
  for(var row = 0; row < 16; row++){
    for(var column = 0; column < 16; column++){
      ctx.fillStyle = whiteSquare.drawWhiteSquare()[row][column];
      ctx.fillRect(whiteSquare.getCoordinates()[row][column][0], whiteSquare.getCoordinates()[row][column][1], whiteSquare.scale, whiteSquare.scale);
    }
  }
  var redSquare = new Graphics(30, 30, 5, 1);
  for(var row = 0; row < 16; row++){
    for(var column = 0; column < 16; column++){
      ctx.fillStyle = redSquare.drawRedSquare()[row][column];
      ctx.fillRect(redSquare.getCoordinates()[row][column][0], redSquare.getCoordinates()[row][column][1], redSquare.scale, redSquare.scale);
    }
  }
  if(clicked){
    console.log("Test")
  }
  clicked = false;
  keyDown = false;
  window.requestAnimationFrame(draw);
};
draw();
