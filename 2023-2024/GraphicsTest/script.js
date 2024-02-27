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
var curWord = "";
var score = 0;
var posY = 0;
var numOfBlocks = 0;
var timer = 90;
var uTimer = 90;
var arrOfBlocks = [];
var log = [];
var attemptNum = 1;
var speedMod = 4;

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
  curWord = "";
  score = 0;
  posY = 0;
  numOfBlocks = 0;
  arrOfBlocks = [];
  timer = uTimer;
  startTime = this.getTime();
}
//Converts a letter to the corrosponding column
UsefulFunctions.prototype.convertToasdfjkl = function(letter) {
  if (letter == "a") {
    return (0)
  }
  if (letter == "s") {
    return (1)
  }
  if (letter == "d") {
    return (2)
  }
  if (letter == "f") {
    return (3)
  }
  if (letter == "g") {
    return (10)
  }
  if (letter == "j") {
    return (4)
  }
  if (letter == "k") {
    return (5)
  }
  if (letter == "l") {
    return (6)
  }
  if (letter == ";") {
    return (7)
  }
}
UsefulFunctions.prototype.generateLetter = function(level) {
  if (level == 0) {
    randNum = Math.floor(Math.random() * 99);
    if (randNum <= 7) {
      return ("a");
    } else if (randNum <= 9) {
      return ("b");
    } else if (randNum <= 13) {
      return ("c");
    } else if (randNum <= 17) {
      return ("d");
    } else if (randNum <= 28) {
      return ("e");
    } else if (randNum <= 29) {
      return ("f");
    } else if (randNum <= 32) {
      return ("g");
    } else if (randNum <= 35) {
      return ("h");
    } else if (randNum <= 44) {
      return ("i");
    } else if (randNum <= 45) {
      return ("j");
    } else if (randNum <= 46) {
      return ("k");
    } else if (randNum <= 51) {
      return ("l");
    } else if (randNum <= 53) {
      return ("m");
    } else if (randNum <= 60) {
      return ("n");
    } else if (randNum <= 66) {
      return ("o");
    } else if (randNum <= 69) {
      return ("p");
    } else if (randNum <= 70) {
      return ("q");
    } else if (randNum <= 77) {
      return ("r");
    } else if (randNum <= 85) {
      return ("s");
    } else if (randNum <= 91) {
      return ("t");
    } else if (randNum <= 94) {
      return ("u");
    } else if (randNum <= 95) {
      return ("v");
    } else if (randNum <= 96) {
      return ("w");
    } else if (randNum <= 97) {
      return ("x");
    } else if (randNum <= 98) {
      return ("y");
    } else if (randNum <= 99) {
      return ("x");
    } else {
      return ("a");
    }
  }
}
UsefulFunctions.prototype.sortArr = function(a,b){
	return(b[2]-a[2]);
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
var arrOfButtons = [new Button("Easy", width / 6, height * 3 / 9, width / 6, height / 9), new Button("Medium", width * 2.5 / 6, height * 3 / 9, width / 6, height / 9), new Button("Hard", width * 4 / 6, height * 3 / 9, width / 6, height / 9), new Button("About", width / 6, height * 5 / 9, width / 6, height / 9), new Button("Instructions", width * 2.5 / 6, height * 5 / 9, width / 6, height / 9), new Button("Leaderboard", width * 4 / 6, height * 5 / 9, width / 6, height / 9)]
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
  var letters = ["a", "s", "d", "f", "j", "k", "l", ";"]
  for (var i = 0; i < 8; i++) {
    if (i >= 4) {
      ctx.fillStyle = 'rgb(0,0,0)';
      ctx.lineWidth = 5;
      ctx.strokeRect(width * i / 10 + width / 5, 0, width / 10, height)
      ctx.fillStyle = "rgb(0, 0, 0, 0.25)";
      ctx.fillRect(width * i / 10 + width / 5, height * 3 / 4, width / 10, height * 1 / 4);
      if (usefulFunctions.convertToasdfjkl(curKeyLetter) == i) {
        ctx.fillStyle = "rgb(255, 255, 255)";
      } else {
        ctx.fillStyle = "rgb(255, 255, 255, 0.25)";
      }
      ctx.font = (width / 11).toString() + "px georgia";
      ctx.fillText(letters[i], width * i / 10 + (width / 11) / 2 + width / 5, height * 3 / 4 + (width / 11));
      ctx.fillStyle = 'rgb(255,255,255)';
    } else if (i < 4) {
      ctx.fillStyle = 'rgb(0,0,0)';
      ctx.lineWidth = 5;
      ctx.strokeRect(width * i / 10, 0, width / 10, height)
      ctx.fillStyle = "rgb(0, 0, 0, 0.25)";
      ctx.fillRect(width * i / 10, height * 3 / 4, width / 10, height * 1 / 4);
      if (usefulFunctions.convertToasdfjkl(curKeyLetter) == i) {
        ctx.fillStyle = "rgb(255, 255, 255)";
      } else {
        ctx.fillStyle = "rgb(255, 255, 255, 0.25)";
      }
      ctx.font = (width / 11).toString() + "px georgia";
      ctx.fillText(letters[i], width * i / 10 + (width / 11) / 2, height * 3 / 4 + (width / 11));
      ctx.fillStyle = 'rgb(255,255,255)';
    }
  }
}
//Class for each letter block
var FallingLetter = function(letter, xPos, yPos, column, size) {
  this.letter = letter;
  this.xPos = xPos;
  this.yPos = yPos;
  this.column = column;
  this.size = size;
  var possiblePositions = [0, width / 10, width * 2 / 10, width * 3 / 10, width * 6 / 10, width * 7 / 10, width * 8 / 10, width * 9 / 10];
  this.xPos = possiblePositions[this.column] + width / 220;
}
//Draws the block
FallingLetter.prototype.drawBlock = function() {
  ctx.fillStyle = "rgb(0, 0, 0)";
  ctx.fillRect(this.xPos, this.yPos, this.size, this.size);
  ctx.fillStyle = "rgb(255, 255, 255)";
  ctx.font = this.size.toString() + "px georgia";
  ctx.fillText(this.letter, this.xPos + this.size / 2, this.yPos + this.size / 1.29);
  ctx.fillStyle = 'rgb(255,255,255)';
}
//Controls the movement
FallingLetter.prototype.moveY = function(speed) {
  this.yPos += speed;
}
//var possiblePositions = [0, width/10, width*2/10, width*3/10, width*6/10, width*7/10, width*8/10, width*9/10]
function draw() {
  ctx.fillStyle = "white";
  ctx.fillRect(0, 0, width, height);
  if (state == 0) {//Intro State- Make Buttons
    ctx.fillStyle = "black";
    ctx.font = Math.floor(width / 11 * (14) ** (-0.25)).toString() + "px georgia";
    ctx.textAlign = 'center';
    ctx.fillText("Wordfall", width / 2, height * 2 / 9);
    ctx.font = Math.floor(width / 11 * (14) ** (-0.55)).toString() + "px georgia";
    for (var i = 0; i < arrOfButtons.length; i++) {
      arrOfButtons[i].drawButton(arrOfButtons[i].checkHover());
      arrOfButtons[i].checkClicked(arrOfButtons[i].checkHover());
    }

  } else if (state == 1) {//Playing State - No Change
    posY = posY + speed;
    if (curKey == 13) {
      if (listOfWords.includes(curWord)) {
        score = score + Math.floor(scoreMultiplier ** curWord.length * 1000);
      }
      curWord = "";
    }
    if ((posY % (width / 7)) <= speed) {
      arrOfBlocks.push(new FallingLetter(usefulFunctions.generateLetter(0), 50, -width / 11, Math.floor(Math.random() * 4), width / 11));
      numOfBlocks++;
    }
    if ((posY % (width / 7)) <= speed) {
      arrOfBlocks.push(new FallingLetter(usefulFunctions.generateLetter(0), 50, -width / 11, Math.floor(Math.random() * 4) + 4, width / 11));
      numOfBlocks++;
    }
    for (var i = 0; i < arrOfBlocks.length; i++) {
      if (arrOfBlocks[i].yPos > height * 3 / 4 - width / 11) {
        if (arrOfBlocks[i].column == usefulFunctions.convertToasdfjkl(curKeyLetter)) {
          curWord = curWord + arrOfBlocks[i].letter;
          arrOfBlocks.splice(i, 1);
          numOfBlocks -= 1;
        }
      }
      if (arrOfBlocks[i].yPos > height) {
        arrOfBlocks.shift();
        numOfBlocks -= 1;
      }
      ctx.fillStyle = "black";
      ctx.font = Math.floor(width / 11 * (curWord.length) ** (-0.55)).toString() + "px georgia";
      ctx.textAlign = 'center';
      ctx.fillText(curWord, width / 2, height * 2 / 7);
      ctx.font = Math.floor(width / 11 * (score.toString().length) ** (-0.55)).toString() + "px georgia";
      ctx.fillText(score, width / 2, height * 3 / 7);
      ctx.font = Math.floor(width / 11 * ((timer - Math.floor((usefulFunctions.getTime() - startTime) / 1000)).toString().length) ** (-0.55)).toString() + "px georgia";
      ctx.fillText(timer - Math.floor((usefulFunctions.getTime() - startTime) / 1000), width / 2, height * 9 / 14);
      arrOfBlocks[i].moveY(speed);
      arrOfBlocks[i].drawBlock();
    }
    //var testerLetter = new FallingLetter('a', curX-50, posY, width/11);
    //testerLetter.drawBlock();
    /*for(var i = 0; i < arrOfBlocks.length; i++){
    arrOfBlocks[i].drawBlock();
    arrOfPos[i]++;
    }*/
    if (timer - Math.floor((usefulFunctions.getTime() - startTime) / 1000) <= 0) {
		log.push([attemptNum, 1/(speed/height * speedMod), score]);
		attemptNum++;
      state = 2;
      setTimeout(1000)
    }
	if(clicked){
		timer = 0;
	}
    drawGameBackground();
  } else if (state == 2) { //End State- No change
    ctx.fillStyle = "black";
    ctx.font = Math.floor(width / 11 * (score.toString().length + 15) ** (-0.55)).toString() + "px georgia";
    ctx.textAlign = 'center';
    ctx.fillText("Your score is: " + score + "      Click to go back to the homepage", width / 2, height / 9);
    if (clicked) {
      state = 0;
    }
  } else if (state == 3) {//Instructions - If Enough time
    ctx.fillStyle = "black";
    ctx.font = Math.floor(width / 11 * (14) ** (-0.55)).toString() + "px georgia";
    ctx.textAlign = 'center';
    ctx.fillText("Instructions", width / 2, height / 9);
    ctx.fillText("Relax! Rest your hands on your keyboard, with your index fingers on the 'f' key and the 'j' key.", width / 2, height * 2 / 9);
    ctx.fillText("Letters will come falling from the top of screen.", width / 2, height * 3 / 9);
    ctx.fillText("When they reach the gray squares, press the key on the gray square!", width / 2, height * 4 / 9);
	ctx.fillText("Try to make words! Longer words get more points. Words less than three letter do not count.", width / 2, height * 5 / 9);
	ctx.fillText("Get the highest score you can! Good luck!", width / 2, height * 6 / 9);
    if (clicked) {
      state = 0;
    }
  } else if (state == 4) {//About page
    ctx.font = Math.floor(width / 11 * (14) ** (-0.25)).toString() + "px georgia";
    ctx.fillStyle = 'rgb(0,0,0)';
    ctx.textAlign = 'center';
    ctx.fillText("Wordfall", width / 2, height * 2 / 11);
    ctx.font = Math.floor(width / 11 * (14) ** (-0.55)).toString() + "px georgia";
    ctx.fillText("A Javascript-based game", width / 2, height * 4 / 11);
    ctx.fillText("designed for the FBLA 22-23 competition", width / 2, height * 5 / 11);
    ctx.fillText("click to go back to the home screen", width / 2, height * 7 / 11);
    ctx.fillText("Alex Liu", width / 6, height * 10 / 11);
    ctx.fillText("Allen Liang", width / 2, height * 10 / 11);
    ctx.fillText("Brian Wei", width * 5 / 6, height * 10 / 11);
    if (clicked) {
      state = 0;
    }
  } else if (state == 5) {//Leaderboard
    ctx.font = Math.floor(width / 11 * (14) ** (-0.25)).toString() + "px georgia";
    ctx.fillStyle = 'rgb(0,0,0)';
    ctx.textAlign = 'center';
    ctx.fillText("Leaderboard", width / 2, height * 2 / 11);
	
    ctx.font = Math.floor(width / 11 * (14) ** (-0.55)).toString() + "px georgia";
	var counter = 0;
	for(var i = 0; i < log.length; i++){
		if(counter < 4){
			var type;
			if(log[i][1] - 100 < 1){
				type = "easy";
			}
			if(log[i][1] - 75 < 1){
				type = "medium";
			}
			if(log[i][1] - 50 < 1){
				type = "hard";
			}
			ctx.fillText("Attempt: " + log[i][0] + "     Difficulty: " + type + "     Score: " + log[i][2], width / 2, height * (i+4) / 11);
		}
		counter++;
	}
	ctx.fillText("Click to go back to the home screen.", width / 2, height * 8/11);
    if (clicked) {
      state = 0;
    }
  }

  clicked = false;
  keyDown = false;
  window.requestAnimationFrame(draw);
};
draw();
