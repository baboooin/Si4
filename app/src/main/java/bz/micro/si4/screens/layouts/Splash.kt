package bz.micro.si4.screens.layouts

const val splashLayout = """ { 
    Logo: {
    start: ['parent', 'start', 50],
    end: ['parent', 'end', 50],
    top: ['parent', 'top', 50],
    bottom: ['Text','top', 50]
}
  Text: {
    start: ['parent', 'start', 50],
    end: ['parent', 'end', 50],
    top: ['Logo', 'bottom', 50],
    bottom: ['parent','bottom', 50]
}


}
 """

const val splashLayoutFront = """ { 
    Text: {
    start: ['parent', 'start', 50],
    end: ['parent', 'end', 50],
    top: ['parent', 'top', 10],
    bottom: ['Button','bottom', 0]
},
    Button: {
    start: ['parent', 'start', 50],
    end: ['parent', 'end', 50],
    top: ['Text', 'top', 10],
    bottom: ['parent','bottom', 10],
    width: 200,
    
    }
}
 """
