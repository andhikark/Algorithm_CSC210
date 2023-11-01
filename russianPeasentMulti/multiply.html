var exp = require('express');
var app = exp();
const router = exp.Router();
var port = 3247;
var path = require('path');

router.get('/',function (request,response) {
    response.sendFile(path.join(__dirname+'/multiply.html'));
}) 

router.get('/time', function (request,response) {
    userNum1 = request.query.number1;
    userNum2 = request.query.number2;
    answer = russianMultiplication(userNum1,userNum2);
    response.write("<html> <body>");
    response.write("<h1> 65130500247 Putu Andhika Restu Kurnia </h1>");
    response.write(userNum1 + " x " + userNum2 + " = " + answer);
    response.write("</body> </html>");
    response.end();
    
});

function russianMultiplication(n, m){
    sum = 0;
    n = parseInt(n);
    m = parseInt(m);

    while(n > 1){
        if(n%2 == 1){//n is odd.
            sum += m;
        }
        // n = Math.floor(n/2); //shift right delete 1 binary
        // m = m *2; //shift left add 1 binary
        // // 6 = 110      6/2 = 3 =>11      3*2 = 6 =>110 
        
        n = shiftRight(n);
        m = shiftLeft(m);
    }
    return(m + sum);
}

function shiftRight( x ){
    binaryX = (x + "").toString(2);
    binaryX = binaryX >>1;
    decimalX = binaryX.toString(10);
    integerX = parseInt(decimalX)
    return integerX;
}

function shiftLeft( x ){
    binaryX = (x + "").toString(2);
    binaryX = binaryX <<1;
    decimalX = binaryX.toString(10);
    integerX = parseInt(decimalX)
    return integerX;
}

app.use('/', router);
var server = app.listen(port, '10.4.53.25', function() {
    console.log("Multiplication app is deployed.")
})
