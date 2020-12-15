# assignment-service
1. Import as maven project.
2. Run as Spring boot Application
3. By default the service will be available on port 8085
4. A sample curl to request the median api:

curl --location --request POST 'http://localhost:8085/data/median/filename.csv' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "id": "3",
        "id2": "5",
        "label":"y"
    },
        {
        "id": "34",
        "id2": "58",
        "label":"y"
    },
        {
        "id": "4",
        "id2": "7",
        "label": "x"
    }
]'

The service is using H2 DB for saving of service requests details. (Please note that H2 DB data is lost when the server stops)
To view the DB on the browser, after starting the server go to this URL:
http://localhost:8085/h2-console

All successfull requests to the median api, will be saved in the DB. The history api retrieves all previous requests details:
curl --location --request GET 'http://localhost:8085/history/median'
