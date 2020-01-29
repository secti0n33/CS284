// Here are the paths to the images
//I pledge my honor that I have abided by the Stevens Honor System.
const fileLocations = {
   woofer: './img/woofer.jpg',
   pupper: './img/pupper.jpg',
   clouds: './img/clouds.jpg',
   snek: './img/snek.jpg'
};

/**
 * This function will get the values of the following elements:
 * 		formUsername, formCaption, formImg
 * Then, this will pass those values to the addNewPost function.
 * @param {Event} event the submit event of the #postForm form
 */
function handleFormSubmit(event) {
   // This next line prevents the reload of the form
   event.preventDefault();
   // Get values of inputs
   // Pass values to addNewPost()
   var user=document.getElementById("formUsername").value;
   var cap=document.getElementById("formCaption").value;
   var img=document.getElementById("formImg").value;
   addNewPost(user,cap,img);
}

/**
 * This function create the following div and append it to the #postList element
	<div class="post">
		<span>{username}</span>
		<img src="{imgLocation}" alt="{caption}">
		<div class="postOverlay">
			{caption}
		</div>
	</div>
 * 
 * Also, add a mouseover and mouseleave events to the post div element
 * @param {String} username username of the post
 * @param {String} caption caption of the post
 * @param {String} imgLocation location of the post image
 */
function addNewPost(username, caption, imgLocation) {
   // Create the parent post div
   // Create a span for the user
   // Create image element
   // Create overlay element
   // Add all child elements (order matters)
   // Add event listeners to post
   // Add post element to post list
   let div=document.createElement("div");
   let span=document.createElement("span");
   let img=document.createElement("img");
   let cap=document.createElement("div");
   cap.className="postOverlay";
   cap.style.opacity="0";
   cap.addEventListener("mouseover",()=>cap.style.opacity="1");
   cap.addEventListener("mouseleave",()=>cap.style.opacity="0");
   cap.innerHTML=caption;
   img.src=fileLocations[imgLocation];
   img.alt=caption;
   span.innerHTML=username;
   span.appendChild(img);
   span.appendChild(cap);
   div.className="post";
   img.style.maxWidth="300px";
   img.style.maxHeight="300px";
   div.appendChild(span);
   document.getElementById("postList").appendChild(div);
}

window.onload = () => {
   // Once our window is loaded, we add the event listener for our post form
   postForm.addEventListener('submit', handleFormSubmit);
};