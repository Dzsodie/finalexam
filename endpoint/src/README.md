**parts of url**

-protocol

-subdomain

-domain

-top level domain

-path

-query parameter (key : value)




**query params**

If you want to identify a resource, you should use Path Variable. 
But if you want to sort or filter items, then you should use query parameter.

/users?occupation=programmer


**header**

HTTP header fields provide required information about the request or response, 
or about the object sent in the message body. There are four types of HTTP message headers:

_General-header:_ 

These header fields have general applicability for both request and response messages.

_Client Request-header:_ 

These header fields have applicability only for request messages.

_Server Response-header:_ 

These header fields have applicability only for response messages.

_Entity-header:_ 

These header fields define meta information about the entity-body or, if no body is present,
 about the resource identified by the request.

https://www.tutorialspoint.com/http/http_header_fields.htm

'<form method="POST" action="foo.php">
 
First Name: <input type="text" name="first_name" /> <br />
Last Name: <input type="text" name="last_name" /> <br />
 
<input type="submit" name="action" value="Submit" />
 
</form>'

POST /foo.php HTTP/1.1
Host: localhost
User-Agent: Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.5) Gecko/20091102 Firefox/3.5.5 (.NET CLR 3.5.30729)
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: en-us,en;q=0.5
Accept-Encoding: gzip,deflate
Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7
Keep-Alive: 300
Connection: keep-alive
Referer: http://localhost/test.php
Content-Type: application/x-www-form-urlencoded
Content-Length: 43
 
first_name=John&last_name=Doe&action=Submit

**body**

An optional body containing data associated with the request (like content of an HTML form), 
or the document associated with a response


**request / response**

request from client to server,

response from server to client

**status (200, 404)**
1xx/ informational
2xx/ success
3xx/ redirect
4xx/ client side error
5xx/ server side error

200 - OK

404 - NOT FOUND

418 - Im a teapot (april fools joke, easter egg in google.com, 
should be returned by teapots requested to brew coffee )

451 - unavailable due to legal reasons

others>
https://developer.mozilla.org/en-US/docs/Web/HTTP/Status

**REST**

Representational State Transfer (REST) web service is the underlying architectural principle of the web.
A web page is a representation of a resource, URL tells the browser about the nouns used in the concept, 
verbs are used based on polymorphism (1 verb can be used with a lot of nouns).
For instance, when you go to a web page, the browser does an HTTP GET on the URL one would type in 
and back comes a web page.

**HTTP, HTTPS**

HTTP> Hypertext Transfer Protocol, an application-layer protocol for transmitting hypermedia documents, such as HTML.

HTTPS> Secured Hypertext Transfer Protocol, the use of an SSL certificate - "SSL" stands for secure sockets layer -
which creates a secure encrypted connection between the web server and the web browser.

**Examples:**

Download pdf endpoint _/done_

GET/POST/PUT * endpoint call or implementation or refactor _/done_

Modify status of an endpoint / return custom HTTP Status from endpoint, can change if an endpoint is enabled, 
if it is considered sensitive and even its id.
application properties> 
endpoints.bean.id=springbeans
endpoints.name.sensitive=false
endpoints.name.enabled=true 

Add error handling to an endpoint _/done_