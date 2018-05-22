URL: http://centaurus-3.ics.uci.edu:2069/


Ki Min Lee (kmlee3, 47872069)

PEDAL WORLD: first element in the menu bar
	- This is also the main welcome page for the website. It does not have anything else other than menu bar and brand logo. 
	- Users are directed to this page when they enter the URL

Product: second element in the menu bar
	- This page contains the list of products. If you move your cursor on to the image, it will zoom in a little, allowing you to see it better. 
	- The list has three columns. One for the image, one for name and product type, and one for product price.
	- If the user wishes to purchase or have better look at the item, clicking on the image will direct you to corresponding product page
	- No zoom in feature for image in the product page. Already displayed enlarged. Users can select different images provided to see the product in different view.
	- If the user wishes to purchase the item, click on the "Add to Cart" button located below the description.
	- Upon clicking on the button, user will be redirected to Check Out page. If the user wishes to purchase a number of same product, simply go back to product detail page and click add to cart again.
	- Entries involving only numbers (e.g phone number, card number), only requires number.
	- Recently viewed items are available at the bottom of the page. Most recent product is the rightmost product. Clicking on the image will redirect the user to corresponding product.
	- Recently viewed products are not unique, so it will have duplicates in user visited same product detail page multiple times.
	- Recently viewed products will only display five most recent products.

About Us: third element in the menu bar
	- This page contains brief information and overview about the company. 
	- It explains the type of product we sell and what we offer offline
	- Contact Us is included in the bottom.

Check Out: fourth element in the menu bar.
	- This hyperlink/button is located in the right side of the menu bar.
	- When user clicks on this link, user will be redirected to a check out page.
	- If user had not added a product yet, it will display as empty.
	- If user had added a product, it will show the list of added product along with quantity, price, and option to remove button.
	- Remove button will only remove selected product, regardless of added quantity.
	- Clear button provided below product list will remove all the products from cart.
	- If user wishes to process with the order, fill out the check out form and click on Order.
	- If successful, user will be redirected to Order Summary page.


***Requirements*** 
	1. Database
		- Product list in "Product" is generated dynamically using the already initialized database, using servlets and JDBC. 
		- For product detail page, thumbnail images(path, not the actual file) are accessed from the database and rendered dynamically.
	2. Database update (insertion)
		- When user submits the order, user data is inserted into the database in orderSubmit.java, then it is forwarded to order summary page. 
	3. Confirmation page
		- After submission, user is directed to confirmation page with details of the order. 
		- After checking the detail, user can navigate to other section using the same menu bar, located at the top.
	4. Session Tracking
		- Session was used for tracking Recently Viewed Products and Shopping cart items.	

