# assignment-service
1. Import as maven project.
2. Run as Spring boot Application
3. By default the service will be available on port 8080
4. A sample curl to request the median api:

curl --location --request POST 'http://localhost:8080/median' \
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
