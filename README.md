## How to use

The project is simple, to provide simple, yet working CRUD API for frontend app.

The entity is `Cat`

## API Overview
* Create cat

`/cats/raise/{catNum}`

Where `catNum` is the number of cats to create.

The HTTP Method is GET for convenience. Change to POST if you prefer so.

For example, to create 10 cats, call:

`/cats/raise/10`

* Get one cat

GET `/cats/{catId}`

* Delete a cat

DELETE `/cats/{catId}`


* List all cats

GET `/cats/list`



* Update a cat

POST `/cats`