// Day 11 - DOM Manipulation (Part 2)

// ===============================
// 1. CREATING ELEMENTS
// ===============================

// Create a new paragraph element
const para = document.createElement("p");
para.textContent = "This is a new paragraph added by JavaScript!";
para.style.color = "blue";

// Append it to the body
document.body.appendChild(para);

// ===============================
// 2. INSERTING BEFORE AN ELEMENT
// ===============================

const heading = document.querySelector("h1"); // Select first h1
const newElement = document.createElement("div");
newElement.textContent = "Inserted before heading!";
document.body.insertBefore(newElement, heading);

// ===============================
// 3. REMOVING ELEMENTS
// ===============================

// Remove the paragraph we added
setTimeout(() => {
  para.remove();
  console.log("Paragraph removed!");
}, 3000); // Wait 3 seconds before removing

// ===============================
// 4. INNER HTML VS TEXT CONTENT
// ===============================

const container = document.createElement("div");

// innerHTML allows HTML tags
container.innerHTML = "<h3>This is <em>innerHTML</em> example</h3>";
document.body.appendChild(container);

// textContent treats everything as plain text
const textOnly = document.createElement("p");
textOnly.textContent = "<b>This will NOT be bold!</b>";
document.body.appendChild(textOnly);

// ===============================
// 5. CLASSLIST METHODS
// ===============================

const box = document.createElement("div");
box.textContent = "I am a box!";
box.classList.add("box");
document.body.appendChild(box);

// Toggle class every second
setInterval(() => {
  box.classList.toggle("highlight");
}, 1000);

// ===============================
// 6. ADDING STYLE DIRECTLY
// ===============================

box.style.width = "200px";
box.style.height = "100px";
box.style.backgroundColor = "lightgreen";
box.style.textAlign = "center";
box.style.lineHeight = "100px";
box.style.marginTop = "10px";

// ===============================
// NOTES
// ===============================
// - createElement(): Creates new elements dynamically
// - appendChild(): Adds an element at the end of a parent
// - insertBefore(): Adds an element before another
// - remove(): Deletes an element from DOM
// - classList.add/remove/toggle: Manage CSS classes dynamically
// - innerHTML lets you insert HTML tags, textContent doesn’t
