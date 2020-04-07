# Checkfer

A few notes:

1) The font doesn't seem right but with out a spec of which one to use it wasn't quite possible to get all the screens 100% correct.

2) I used Databinding in one area (Lawyer02) which is the details screen. This was more to show DataBinding. It was not used for the onclick listeners even though it would be normally. 

3) The Model is just thrown together to make it work. It would not work like that in a production app since the Object would be given to me via JSON in an API. The object I had would match the JSON perfectly. I would also have some of the getters work differently but without an API backend I didn't see the point in perfecting this class. For example I have Strings in there which are not in Strings.xml. This wouldn't happen on a production app. 

4) Lawyer Details Activity. The views for Rating / Reviews / Ranking > I would also do this differently if this was used more or needed more control. Right now I do have duplicated XML code for this. I would easily have an XML layout for this and use a custom view with app:setCustomHintText app:setCustomImageSrc app:setText. 

5) The Activity uses animations to load into the Details Activity. I didn't set every view to animate, mostly as this would look weird if every view was to animate. I can explain this more via a call. 

6) Parralax - I didn't manage to do this. Mostly as I set myself a deadline to get this sent over today. 

7) Some views are not 100% correct - The images I have of what they need to look like are quite small (750 x 1333) which is far below screen resolutions of phones these days. 
