package com.example.weatherwise.ApiPackage;

import java.util.ArrayList;

public class HourlyWeatherResponseModel {

    public class Astro{
        public String sunrise;
        public String sunset;
        public String moonrise;
        public String moonset;
        public String moon_phase;
        public int moon_illumination;
        public int is_moon_up;
        public int is_sun_up;

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public String getMoonrise() {
            return moonrise;
        }

        public void setMoonrise(String moonrise) {
            this.moonrise = moonrise;
        }

        public String getMoonset() {
            return moonset;
        }

        public void setMoonset(String moonset) {
            this.moonset = moonset;
        }

        public String getMoon_phase() {
            return moon_phase;
        }

        public void setMoon_phase(String moon_phase) {
            this.moon_phase = moon_phase;
        }

        public int getMoon_illumination() {
            return moon_illumination;
        }

        public void setMoon_illumination(int moon_illumination) {
            this.moon_illumination = moon_illumination;
        }

        public int getIs_moon_up() {
            return is_moon_up;
        }

        public void setIs_moon_up(int is_moon_up) {
            this.is_moon_up = is_moon_up;
        }

        public int getIs_sun_up() {
            return is_sun_up;
        }

        public void setIs_sun_up(int is_sun_up) {
            this.is_sun_up = is_sun_up;
        }
    }

    public class Condition{
        public String text;
        public String icon;
        public int code;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    public class Current{
        public int last_updated_epoch;
        public String last_updated;
        public int temp_c;
        public double temp_f;
        public int is_day;
        public Condition condition;
        public double wind_mph;
        public double wind_kph;
        public int wind_degree;
        public String wind_dir;
        public int pressure_mb;
        public double pressure_in;
        public double precip_mm;
        public int precip_in;
        public int humidity;
        public int cloud;
        public double feelslike_c;
        public double feelslike_f;
        public int vis_km;
        public int vis_miles;
        public int uv;
        public double gust_mph;
        public double gust_kph;

        public int getLast_updated_epoch() {
            return last_updated_epoch;
        }

        public void setLast_updated_epoch(int last_updated_epoch) {
            this.last_updated_epoch = last_updated_epoch;
        }

        public String getLast_updated() {
            return last_updated;
        }

        public void setLast_updated(String last_updated) {
            this.last_updated = last_updated;
        }

        public int getTemp_c() {
            return temp_c;
        }

        public void setTemp_c(int temp_c) {
            this.temp_c = temp_c;
        }

        public double getTemp_f() {
            return temp_f;
        }

        public void setTemp_f(double temp_f) {
            this.temp_f = temp_f;
        }

        public int getIs_day() {
            return is_day;
        }

        public void setIs_day(int is_day) {
            this.is_day = is_day;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        public double getWind_mph() {
            return wind_mph;
        }

        public void setWind_mph(double wind_mph) {
            this.wind_mph = wind_mph;
        }

        public double getWind_kph() {
            return wind_kph;
        }

        public void setWind_kph(double wind_kph) {
            this.wind_kph = wind_kph;
        }

        public int getWind_degree() {
            return wind_degree;
        }

        public void setWind_degree(int wind_degree) {
            this.wind_degree = wind_degree;
        }

        public String getWind_dir() {
            return wind_dir;
        }

        public void setWind_dir(String wind_dir) {
            this.wind_dir = wind_dir;
        }

        public int getPressure_mb() {
            return pressure_mb;
        }

        public void setPressure_mb(int pressure_mb) {
            this.pressure_mb = pressure_mb;
        }

        public double getPressure_in() {
            return pressure_in;
        }

        public void setPressure_in(double pressure_in) {
            this.pressure_in = pressure_in;
        }

        public double getPrecip_mm() {
            return precip_mm;
        }

        public void setPrecip_mm(double precip_mm) {
            this.precip_mm = precip_mm;
        }

        public int getPrecip_in() {
            return precip_in;
        }

        public void setPrecip_in(int precip_in) {
            this.precip_in = precip_in;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public int getCloud() {
            return cloud;
        }

        public void setCloud(int cloud) {
            this.cloud = cloud;
        }

        public double getFeelslike_c() {
            return feelslike_c;
        }

        public void setFeelslike_c(double feelslike_c) {
            this.feelslike_c = feelslike_c;
        }

        public double getFeelslike_f() {
            return feelslike_f;
        }

        public void setFeelslike_f(double feelslike_f) {
            this.feelslike_f = feelslike_f;
        }

        public int getVis_km() {
            return vis_km;
        }

        public void setVis_km(int vis_km) {
            this.vis_km = vis_km;
        }

        public int getVis_miles() {
            return vis_miles;
        }

        public void setVis_miles(int vis_miles) {
            this.vis_miles = vis_miles;
        }

        public int getUv() {
            return uv;
        }

        public void setUv(int uv) {
            this.uv = uv;
        }

        public double getGust_mph() {
            return gust_mph;
        }

        public void setGust_mph(double gust_mph) {
            this.gust_mph = gust_mph;
        }

        public double getGust_kph() {
            return gust_kph;
        }

        public void setGust_kph(double gust_kph) {
            this.gust_kph = gust_kph;
        }
    }

    public class Day{
        public double maxtemp_c;
        public double maxtemp_f;
        public double mintemp_c;
        public double mintemp_f;
        public double avgtemp_c;
        public double avgtemp_f;
        public double maxwind_mph;
        public double maxwind_kph;
        public double totalprecip_mm;
        public double totalprecip_in;
        public int totalsnow_cm;
        public int avgvis_km;
        public int avgvis_miles;
        public int avghumidity;
        public int daily_will_it_rain;
        public int daily_chance_of_rain;
        public int daily_will_it_snow;
        public int daily_chance_of_snow;
        public Condition condition;
        public int uv;

        public double getMaxtemp_c() {
            return maxtemp_c;
        }

        public void setMaxtemp_c(double maxtemp_c) {
            this.maxtemp_c = maxtemp_c;
        }

        public double getMaxtemp_f() {
            return maxtemp_f;
        }

        public void setMaxtemp_f(double maxtemp_f) {
            this.maxtemp_f = maxtemp_f;
        }

        public double getMintemp_c() {
            return mintemp_c;
        }

        public void setMintemp_c(double mintemp_c) {
            this.mintemp_c = mintemp_c;
        }

        public double getMintemp_f() {
            return mintemp_f;
        }

        public void setMintemp_f(double mintemp_f) {
            this.mintemp_f = mintemp_f;
        }

        public double getAvgtemp_c() {
            return avgtemp_c;
        }

        public void setAvgtemp_c(double avgtemp_c) {
            this.avgtemp_c = avgtemp_c;
        }

        public double getAvgtemp_f() {
            return avgtemp_f;
        }

        public void setAvgtemp_f(double avgtemp_f) {
            this.avgtemp_f = avgtemp_f;
        }

        public double getMaxwind_mph() {
            return maxwind_mph;
        }

        public void setMaxwind_mph(double maxwind_mph) {
            this.maxwind_mph = maxwind_mph;
        }

        public double getMaxwind_kph() {
            return maxwind_kph;
        }

        public void setMaxwind_kph(double maxwind_kph) {
            this.maxwind_kph = maxwind_kph;
        }

        public double getTotalprecip_mm() {
            return totalprecip_mm;
        }

        public void setTotalprecip_mm(double totalprecip_mm) {
            this.totalprecip_mm = totalprecip_mm;
        }

        public double getTotalprecip_in() {
            return totalprecip_in;
        }

        public void setTotalprecip_in(double totalprecip_in) {
            this.totalprecip_in = totalprecip_in;
        }

        public int getTotalsnow_cm() {
            return totalsnow_cm;
        }

        public void setTotalsnow_cm(int totalsnow_cm) {
            this.totalsnow_cm = totalsnow_cm;
        }

        public int getAvgvis_km() {
            return avgvis_km;
        }

        public void setAvgvis_km(int avgvis_km) {
            this.avgvis_km = avgvis_km;
        }

        public int getAvgvis_miles() {
            return avgvis_miles;
        }

        public void setAvgvis_miles(int avgvis_miles) {
            this.avgvis_miles = avgvis_miles;
        }

        public int getAvghumidity() {
            return avghumidity;
        }

        public void setAvghumidity(int avghumidity) {
            this.avghumidity = avghumidity;
        }

        public int getDaily_will_it_rain() {
            return daily_will_it_rain;
        }

        public void setDaily_will_it_rain(int daily_will_it_rain) {
            this.daily_will_it_rain = daily_will_it_rain;
        }

        public int getDaily_chance_of_rain() {
            return daily_chance_of_rain;
        }

        public void setDaily_chance_of_rain(int daily_chance_of_rain) {
            this.daily_chance_of_rain = daily_chance_of_rain;
        }

        public int getDaily_will_it_snow() {
            return daily_will_it_snow;
        }

        public void setDaily_will_it_snow(int daily_will_it_snow) {
            this.daily_will_it_snow = daily_will_it_snow;
        }

        public int getDaily_chance_of_snow() {
            return daily_chance_of_snow;
        }

        public void setDaily_chance_of_snow(int daily_chance_of_snow) {
            this.daily_chance_of_snow = daily_chance_of_snow;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        public int getUv() {
            return uv;
        }

        public void setUv(int uv) {
            this.uv = uv;
        }
    }

    public class Forecast{
        public ArrayList<Forecastday> forecastday;

        public ArrayList<Forecastday> getForecastday() {
            return forecastday;
        }

        public void setForecastday(ArrayList<Forecastday> forecastday) {
            this.forecastday = forecastday;
        }
    }

    public class Forecastday{
        public String date;
        public int date_epoch;
        public Day day;
        public Astro astro;
        public ArrayList<Hour> hour;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getDate_epoch() {
            return date_epoch;
        }

        public void setDate_epoch(int date_epoch) {
            this.date_epoch = date_epoch;
        }

        public Day getDay() {
            return day;
        }

        public void setDay(Day day) {
            this.day = day;
        }

        public Astro getAstro() {
            return astro;
        }

        public void setAstro(Astro astro) {
            this.astro = astro;
        }

        public ArrayList<Hour> getHour() {
            return hour;
        }

        public void setHour(ArrayList<Hour> hour) {
            this.hour = hour;
        }
    }

    public class Hour{
        public int time_epoch;
        public String time;
        public double temp_c;
        public double temp_f;
        public int is_day;
        public Condition condition;
        public double wind_mph;
        public double wind_kph;
        public int wind_degree;
        public String wind_dir;
        public int pressure_mb;
        public double pressure_in;
        public double precip_mm;
        public double precip_in;
        public int humidity;
        public int cloud;
        public double feelslike_c;
        public double feelslike_f;
        public double windchill_c;
        public double windchill_f;
        public double heatindex_c;
        public double heatindex_f;
        public double dewpoint_c;
        public double dewpoint_f;
        public int will_it_rain;
        public int chance_of_rain;
        public int will_it_snow;
        public int chance_of_snow;
        public int vis_km;
        public int vis_miles;
        public double gust_mph;
        public double gust_kph;
        public int uv;

        public int getTime_epoch() {
            return time_epoch;
        }

        public void setTime_epoch(int time_epoch) {
            this.time_epoch = time_epoch;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public double getTemp_c() {
            return temp_c;
        }

        public void setTemp_c(double temp_c) {
            this.temp_c = temp_c;
        }

        public double getTemp_f() {
            return temp_f;
        }

        public void setTemp_f(double temp_f) {
            this.temp_f = temp_f;
        }

        public int getIs_day() {
            return is_day;
        }

        public void setIs_day(int is_day) {
            this.is_day = is_day;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        public double getWind_mph() {
            return wind_mph;
        }

        public void setWind_mph(double wind_mph) {
            this.wind_mph = wind_mph;
        }

        public double getWind_kph() {
            return wind_kph;
        }

        public void setWind_kph(double wind_kph) {
            this.wind_kph = wind_kph;
        }

        public int getWind_degree() {
            return wind_degree;
        }

        public void setWind_degree(int wind_degree) {
            this.wind_degree = wind_degree;
        }

        public String getWind_dir() {
            return wind_dir;
        }

        public void setWind_dir(String wind_dir) {
            this.wind_dir = wind_dir;
        }

        public int getPressure_mb() {
            return pressure_mb;
        }

        public void setPressure_mb(int pressure_mb) {
            this.pressure_mb = pressure_mb;
        }

        public double getPressure_in() {
            return pressure_in;
        }

        public void setPressure_in(double pressure_in) {
            this.pressure_in = pressure_in;
        }

        public double getPrecip_mm() {
            return precip_mm;
        }

        public void setPrecip_mm(double precip_mm) {
            this.precip_mm = precip_mm;
        }

        public double getPrecip_in() {
            return precip_in;
        }

        public void setPrecip_in(double precip_in) {
            this.precip_in = precip_in;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public int getCloud() {
            return cloud;
        }

        public void setCloud(int cloud) {
            this.cloud = cloud;
        }

        public double getFeelslike_c() {
            return feelslike_c;
        }

        public void setFeelslike_c(double feelslike_c) {
            this.feelslike_c = feelslike_c;
        }

        public double getFeelslike_f() {
            return feelslike_f;
        }

        public void setFeelslike_f(double feelslike_f) {
            this.feelslike_f = feelslike_f;
        }

        public double getWindchill_c() {
            return windchill_c;
        }

        public void setWindchill_c(double windchill_c) {
            this.windchill_c = windchill_c;
        }

        public double getWindchill_f() {
            return windchill_f;
        }

        public void setWindchill_f(double windchill_f) {
            this.windchill_f = windchill_f;
        }

        public double getHeatindex_c() {
            return heatindex_c;
        }

        public void setHeatindex_c(double heatindex_c) {
            this.heatindex_c = heatindex_c;
        }

        public double getHeatindex_f() {
            return heatindex_f;
        }

        public void setHeatindex_f(double heatindex_f) {
            this.heatindex_f = heatindex_f;
        }

        public double getDewpoint_c() {
            return dewpoint_c;
        }

        public void setDewpoint_c(double dewpoint_c) {
            this.dewpoint_c = dewpoint_c;
        }

        public double getDewpoint_f() {
            return dewpoint_f;
        }

        public void setDewpoint_f(double dewpoint_f) {
            this.dewpoint_f = dewpoint_f;
        }

        public int getWill_it_rain() {
            return will_it_rain;
        }

        public void setWill_it_rain(int will_it_rain) {
            this.will_it_rain = will_it_rain;
        }

        public int getChance_of_rain() {
            return chance_of_rain;
        }

        public void setChance_of_rain(int chance_of_rain) {
            this.chance_of_rain = chance_of_rain;
        }

        public int getWill_it_snow() {
            return will_it_snow;
        }

        public void setWill_it_snow(int will_it_snow) {
            this.will_it_snow = will_it_snow;
        }

        public int getChance_of_snow() {
            return chance_of_snow;
        }

        public void setChance_of_snow(int chance_of_snow) {
            this.chance_of_snow = chance_of_snow;
        }

        public int getVis_km() {
            return vis_km;
        }

        public void setVis_km(int vis_km) {
            this.vis_km = vis_km;
        }

        public int getVis_miles() {
            return vis_miles;
        }

        public void setVis_miles(int vis_miles) {
            this.vis_miles = vis_miles;
        }

        public double getGust_mph() {
            return gust_mph;
        }

        public void setGust_mph(double gust_mph) {
            this.gust_mph = gust_mph;
        }

        public double getGust_kph() {
            return gust_kph;
        }

        public void setGust_kph(double gust_kph) {
            this.gust_kph = gust_kph;
        }

        public int getUv() {
            return uv;
        }

        public void setUv(int uv) {
            this.uv = uv;
        }
    }

    public class Location{
        public String name;
        public String region;
        public String country;
        public double lat;
        public double lon;
        public String tz_id;
        public int localtime_epoch;
        public String localtime;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public String getTz_id() {
            return tz_id;
        }

        public void setTz_id(String tz_id) {
            this.tz_id = tz_id;
        }

        public int getLocaltime_epoch() {
            return localtime_epoch;
        }

        public void setLocaltime_epoch(int localtime_epoch) {
            this.localtime_epoch = localtime_epoch;
        }

        public String getLocaltime() {
            return localtime;
        }

        public void setLocaltime(String localtime) {
            this.localtime = localtime;
        }
    }

    public class Root{
        public Location location;
        public Current current;
        public Forecast forecast;

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public Current getCurrent() {
            return current;
        }

        public void setCurrent(Current current) {
            this.current = current;
        }

        public Forecast getForecast() {
            return forecast;
        }

        public void setForecast(Forecast forecast) {
            this.forecast = forecast;
        }
    }


}