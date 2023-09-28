function search(pattern) {
    var puzzle2D = document.getElementById("puzzleTable");
    height = puzzle2D.rows.length;
    width = puzzle2D.rows[0].cells.length;
    patternLength = pattern.length;
    
    foundAt = 'Not Found';

    for (let row = 0; row < height; row++) {
        for (let column = 0; column < width; column++) {
            // Case 1: From left to right
            if (column <= width - patternLength) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row].cells[column + j].innerHTML) {
                    j++;
                }
                if (j == patternLength) {
                    foundAt = '[' + row + ',' + column + '] to the right';
                    break;
                }
            }

            // Case 2: From right to left
            if (column >= patternLength - 1) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row].cells[column - j].innerHTML) {
                    j++;
                }
                if (j == patternLength) {
                    foundAt = '[' + row + ',' + column + '] to the left';
                    break;
                }
            }

            // Case 3: From up to bottom
            if (row <= height - patternLength) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row + j].cells[column].innerHTML) {
                    j++;
                }
                if (j == patternLength) {
                    foundAt = '[' + row + ',' + column + '] to the bottom ';
                    break;
                }
            }

            // Case 4: From bottom to up
            if (row >= patternLength - 1) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row - j].cells[column].innerHTML) {
                    j++;
                }
                if (j == patternLength) {
                    foundAt = '[' + row + ',' + column + '] to the top ';
                    break;
                }
            }

            // Case 5: Diagonal up right --> bottom-left to up-right
            if (column <= width - patternLength && row >= patternLength - 1) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row - j].cells[column + j].innerHTML) {
                    j++;
                }
                if (j == patternLength) {
                    foundAt = '[' + row + ',' + column + '] diagonal up right';
                    break;
                }
            }

            // Case 6: Diagonal up left --> bottom-right to up-left
            if (column >= patternLength - 1 && row >= patternLength - 1) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row - j].cells[column - j].innerHTML) {
                    j++;
                }
                if (j == patternLength) {
                    foundAt = '[' + row + ',' + column + '] diagonal up left';
                    break;
                }
            }

            // Case 7: Diagonal bottom right --> up-left to bottom-right
            if (column <= width - patternLength && row <= height - patternLength) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row + j].cells[column + j].innerHTML) {
                    j++;
                }
                if (j == patternLength) {
                    foundAt = '[' + row + ',' + column + '] diagonal bottom right';
                    break;
                }
            }

            // Case 8: Diagonal bottom left --> up-right to bottom-left
            if (column >= patternLength - 1 && row <= height - patternLength) {
                let j = 0;
                while (j < patternLength && pattern.charAt(j) == puzzle2D.rows[row + j].cells[column - j].innerHTML) {
                    j++;
                }
                if (j == patternLength) {
                    foundAt = '[' + row + ',' + column + '] diagonal bottom left';
                    break;
                }
            }
        }

        if (foundAt != 'Not Found') {
            break;
        }
    }

    alert(foundAt);
}
