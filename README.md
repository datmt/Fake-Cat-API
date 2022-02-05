## How to use

The project is simple, to provide simple, yet working CRUD API for frontend app.

The entity is `Cat`

You can quickly start the api using docker

```shell

docker run --rm -p 9999:9090 codingpuss/fake-cat-api

```

In the example above, I used external port `9999`. Change this to whatever port number that suits you.

Now, you can access the API at `http://localhost:9999/`


See API details below



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



## License

MIT


## About me

I'm a software developer. I blog at [https://datmt.com](https://datmt.com)