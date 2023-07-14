from flask import Flask, request
from flask_restful import Resource, Api
from googleapiclient.discovery import build
import openai

app = Flask(__name__)
api = Api(app)

class GoogleSearch(Resource):
    def get(self, query):
        service = build("customsearch", "v1", developerKey="<YOUR_DEVELOPER_KEY>")
        res = service.cse().list(q=query, cx='<YOUR_CX>').execute()
        return res['items']

class OpenAIApi(Resource):
    def post(self):
        data = request.get_json()
        api_key = data.get('apikey')
        prompt = data.get('prompt')

        openai.api_key = api_key
        response = openai.Completion.create(
          engine="text-davinci-002",
          prompt=prompt,
          max_tokens=150
        )

        return response.choices[0].text.strip()

api.add_resource(GoogleSearch, '/googlesearch/<string:query>')
api.add_resource(OpenAIApi, '/openai')

if __name__ == '__main__':
    app.run(debug=True)
