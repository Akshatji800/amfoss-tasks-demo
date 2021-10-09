import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MaterialApp(
    debugShowCheckedModeBanner: false,
    home: Home(),
  ));
}

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  PageController pageController;
  int activePage = 0;

  @override
  void initState() {
    pageController = PageController(keepPage: true, initialPage: 0);
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    SystemChrome.setSystemUIOverlayStyle(SystemUiOverlayStyle.dark.copyWith(statusBarColor: Colors.white));
    return Scaffold(
      backgroundColor: Colors.white,
      body: SafeArea(
        child: Padding(
          padding: EdgeInsets.only(top: 15),
          child: Column(
            children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  AnimatedContainer(
                    duration: Duration(milliseconds: 250),
                    height: 10,
                    width: activePage == 0 ? 80 : 10,
                    decoration: BoxDecoration(borderRadius: BorderRadius.all(Radius.circular(10)), color: Color(0xff723BFF).withAlpha(activePage == 0 ? 255 : 100)),
                  ),
                  Container(width: 10),
                  AnimatedContainer(
                    duration: Duration(milliseconds: 250),
                    height: 10,
                    width: activePage != 0 ? 80 : 10,
                    decoration: BoxDecoration(borderRadius: BorderRadius.all(Radius.circular(10)), color: Color(0xff723BFF).withAlpha(activePage != 0 ? 255 : 100)),
                  )
                ],
              ),
              Container(height: 20),
              Expanded(
                  child: PageView(
                pageSnapping: true,
                controller: pageController,
                scrollDirection: Axis.horizontal,
                children: [
                  Container(
                    child: Stack(children: [
                      Image.asset("assets/art-cloud.png", height: 400),
                      Padding(
                        padding: EdgeInsets.only(top: 60),
                        child: Align(alignment: Alignment.centerRight, child: Image.asset("assets/art-work.png", height: 300)),
                      ),
                      Padding(
                        padding: EdgeInsets.only(left: 20),
                        child: Align(
                            alignment: Alignment.bottomLeft,
                            child: RichText(
                              text: TextSpan(children: [
                                TextSpan(text: "Hello!\n", style: TextStyle(color: Color(0xff723BFF), fontSize: 18, fontWeight: FontWeight.w500)),
                                TextSpan(text: "Your own\nprivate Cloud is\none step away!\n\n\n", style: TextStyle(color: Color(0xff100048), fontSize: 35, fontWeight: FontWeight.bold)),
                                TextSpan(text: "Swipe left to get started.", style: TextStyle(color: Color(0xff723BFF), fontSize: 16, fontWeight: FontWeight.w500)),
                              ]),
                            )),
                      )
                    ], fit: StackFit.loose, overflow: Overflow.clip),
                  ),
                  Container(
                    child: Stack(children: [
                      Padding(
                        padding: EdgeInsets.only(top: 50),
                        child: Align(alignment: Alignment.topCenter, child: Image.asset("assets/art-stairs.png", height: 350)),
                      ),
                      Padding(
                        padding: EdgeInsets.only(left: 20),
                        child: Align(
                            alignment: Alignment.bottomLeft,
                            child: RichText(
                              text: TextSpan(children: [
                                TextSpan(text: "Your Premium Cloud\n", style: TextStyle(color: Color(0xff723BFF), fontSize: 18, fontWeight: FontWeight.w500)),
                                TextSpan(
                                    text: "Launch your next\ncampaign within minutes\nwith Cloud Campaign\nMonitor.",
                                    style: TextStyle(color: Color(0xff100048), fontSize: 30, fontWeight: FontWeight.bold)),
                              ]),
                            )),
                      )
                    ]),
                  )
                ],
                onPageChanged: (index) => setState(() => activePage = index),
              )),
              Container(height: 20),
              Container(
                decoration: BoxDecoration(borderRadius: BorderRadius.all(Radius.circular(10)), color: Color(0xff723BFF)),
                margin: EdgeInsets.only(top: 5, bottom: 15, right: 15, left: 15),
                padding: EdgeInsets.symmetric(vertical: 20),
                alignment: Alignment.center,
                child: Text('Create an account', style: TextStyle(color: Colors.white, fontSize: 20, fontWeight: FontWeight.w500)),
              )
            ],
          ),
        ),
      ),
    );
  }
}
