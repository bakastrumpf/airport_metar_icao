# airport_metar_icao
BE test assignment


the .sh script is a result of various commands found online - seems like parsing data containing "/" does not work.

all in all, given I am not proficient in running shell scripts in Terminal, I hope my partially funcional code still counts, 
and that it at least shows I have a somewhat limited knowledge that definitely needs more work, which I am willing to provide
in the future.

in case it doesn't show, the metar-script.sh contains the following:

subscriptions=$(curl http://localhost:8080/subscriptions) 
echo $subscriptions
icaoCodes=$(jq -r '.[]|"\(.icaoCode)"' <<< "${subscriptions}") 
echo "${icaoCodes}"

for icaoCode in $icaoCodes; do
    data=$(curl https://tgftp.nws.noaa.gov/data/observations/metar/stations/$icaoCode.TXT)
    echo $data
    #printf -v json -- '{ "data": "%s"}' "$data"
    body='{"data":"'"$data"'"}'
    echo $body
    $(curl -X POST -H "Content-Type: application/json" -d "$json" "http://localhost:8080/airport/$icaoCode/METAR")
done
