
<p align="center">
  <a href="" rel="noopener">
    <img src="https://i.imgur.com/GdVoGvv.png" alt="Project logo">
  </a>
</p>

<h3 align="center">Malaria Diagnosis Tool</h3>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)](https://github.com/JamesWRC/MDT_GUI)
[![GitHub Issues](https://img.shields.io/github/issues/jameswrc/MDT_GUI.svg)](https://github.com/JamesWRC/MDT_GUI/issues)
[![GitHub Pull Requests](https://img.shields.io/github/issues-pr/JamesWRC/MDT_GUI.svg)](https://github.com/JamesWRC/MDT_GUI/pulls)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE.md)

</div>

---

<p align="center">
This Malaria Diagnosis Tool (MDT) helps lab scientists diagnose which type of malaria the patient may have depending on the country they have recently come from.

- This is a full GUI version which essentaily means its just a visual interface of the program. It has all the features of the Command Line Interface (CLI) version.
- For a CLI version [please go here](https://github.com/JamesWRC/MDT_Lite)

</p>

## 📝 Table of Contents

- [Why Use This Tool?](#why_use_this_tool)
- [How to install and use](#how_to_use)
- [Images](#images)
- [Known bugs](#known_bugs)
- [Planned Features](#planned_features)

# Why Use This Tool <a name = "why_use_this_tool"></a>

If you're a lab scientist and/or work in pathology you would be used to viewing blood slides to assess which type of Malaria the patient may have so the patient can get the right treatment.

Sometimes you may get either a Country Name or Country Code of where the patient is from / has recenlty come from and may take a long time to lookup the country and see which malaria type is more prevalent. You can enter either the country name OR country code and this toll will still display results.

- Fast - Get Malaria types and their likeliness in seconds.
- Easy To Use - Can enter country name OR country code. And if you dont feel like using a GUI, then there is even an even easier to use [CLI Version Here!](https://github.com/JamesWRC/MDT_Lite)
- Simple - Just type in a countrys name or code and the likeliness of each Malaria type is displayed in a nice orderly fassion.
- Easy to set up

# How to install and use <a name = "how_to_use"></a>

IMPORTANT: You must have Java installed onto the computers you want to use this program on. You can get the latest java [here](https://www.java.com/en/download/).
Please note, you may have to compile the project yourself if your version of java won't run it.
If you have any issues running MDT please open a suport ticket [here](https://github.com/JamesWRC/MDT_GUI/issues)

1. Download the 'MDT_GUI.jar' file above. All versions are found [here](https://github.com/JamesWRC/MDYT_GUI/tree/master/releases)
2. double click the .jar file
3. Done! Enjoy
   For some basic examples of how to use the tool please see the [images](#images) below.

# Images <a name = "images"></a>

## Note: your verion of MDT_Lite may be different to the file in the images below

<img src="https://i.imgur.com/Kk7iOa3.gif" alt="Project image1" width="260" height="400">
<br>
Easily select a country by name or by country code.

<hr>

  <img src="https://i.imgur.com/JNzK6En.gif" alt="Project image2" width="260" height="400">
  <br>
As you can see, the malaria types and likeiness is shown via a percentage and a filled in bar.

<hr>

# Known Bugs<a name = "known_bugs"></a>

- When selecting a country via name and that country has some type of malaria,
  then search for another country via the country code, the bars will not update.

# Planned Features<a name = "planned_features"></a>

- The ability to edit notes for a country
- A help view, under the menu.
- Search by typing a country name.
- Change this readme.md for betetr understand between the two versions.
