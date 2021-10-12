#!/usr/bin/env/ python3
import urllib.request
import urllib.parse
import http.client
import json

def neighbours(djson):
    print("")
    print("The neighbouring contries to germany are: \n")
    print("Germany Country code: 2921044") 
    print()
    for geoname in djson['geonames'] :
        print("Name : " + geoname ['name'] +'\t CountryCode : ' + geoname['countryCode'])


username = 'daniel_212'
service = 'neighboursJSON?'
geonameId = '2921044'


try: 

    url = 'http://api.geonames.org/'+ service + 'geonameId='+geonameId+'&username='+username
    f = urllib.request.urlopen(url,timeout=30)
    djson = json.loads(f.read())
    #print(djson)
    neighbours(djson)
    

except:
    print("Error")