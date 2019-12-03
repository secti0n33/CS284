var result, currentOP, buffer;

resetCalc();
/**
 * Resets the state of the calculator and the display
 */
function resetCalc() {
   result = 0;
   currentOP = '';
   buffer = 0;
   setDisplay("0");
}

/**
 * Sets the inner text of the div with id="output"
 * @param {String} str the string to set the inner text to
 */
function setDisplay(str) {
   var output = document.getElementById("output").innerHTML = str;
}

/**
 * Returns the current result of the calculator
 * Hint: you can use a global variable for the result
 */
function getResult() {
   return result;
}

/**
 * Checks if number is inbetween two bounds
 * @param {*} number the number to check
 */
function checkBounds(number) {
   // implement
   return  number <= 999999999 && number >= -999999999;
}

/**
 * Update the calculator state with the next number and sets the display
 * @param {Number} num the number that was pressed
 */
function pressNum(num) {
   // implement
   var nextNum = result + '' + num;
   if(result == 0) {
      nextNum = num;
   } 
   result = (checkBounds(nextNum))?nextNum: (nextNum>0)?999999999:-999999999;
   setDisplay(getResult());
}

/**
 * Operation is pressed, move the current result value to a temporary buffer and
 * set the current result to zero.
 * @param {String} op the operation pressed, either: +,-,*,/
 */
function pressOp(op) {
   // implement
   currentOP = op;
   if(result != 0) {
      buffer = result;
      result = 0;
   }
   setDisplay(getResult());
}

/**
 * Should compute the current operation with the buffer value and current
 * result value based on the current operation. If there is no current
 * operation, do nothing.
 */
function pressEquals() {
   // implement
   buffer = Number(buffer)
   result = Number(result);
   var tryResult;
   if(currentOP=="+")
      tryResult = buffer + result;
   else if(currentOP == '-')
      tryResult = buffer - result;
   else if(currentOP == '*')
      tryResult = buffer * result;
   else if(currentOP == '/')
      if(result != 0)
         tryResult = buffer/result;
      else
      {
         setDisplay("ERROR");
         return;
      }

   if(checkBounds(tryResult) != false) {
      result = Math.trunc(tryResult);
   }
   setDisplay(getResult());
}