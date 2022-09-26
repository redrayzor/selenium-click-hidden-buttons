// change class of button and increment counter
let counter = 0;
const pagetext = document.querySelector('.sometext');
pagetext.textContent = "Count: " + counter;

const bluetext = () => {
    const someelement = document.getElementById('ele_a');
    someelement.className = 'blue';
    counter++;
    pagetext.textContent = "Clicks: " + counter;
}

// handle click
const firstbutton = document.getElementById('button_a');
firstbutton.addEventListener('click',bluetext);

// second button
const button2 = document.getElementById('button_b');
const coverbutton = () => {
    const someelement = document.getElementById('ele_b');
    someelement.className = 'cover';
    counter++;
    pagetext.textContent = "Clicks: " + counter;
}
button2.addEventListener('click',coverbutton)

// third button
const button3 = document.getElementById('button_c');
const removedisplay = () => {
    button3.className = 'no_display';
    counter++;
    pagetext.textContent = "Clicks: " + counter;
}
button3.addEventListener('click',removedisplay);

// fourth button
const button4 = document.getElementById('button_d');
const hidebutton = () => {
    button4.className = 'hidden_button';
    counter++;
    pagetext.textContent = "Clicks: " + counter;
}
button4.addEventListener('click',hidebutton);