const puppeteer = require("puppeteer");

async function scrape(url) {
  const browser = await puppeteer.launch({ headless: false });
  const page = await browser.newPage();
  await page.goto(url);
  await page.waitForSelector("span [title='Shubhang Delhi']");
  const target = await page.$("span [title='Shubhang Delhi']");
  await target.click();
  const inp = await page.$(
    "#main > footer > div._3SvgF._1mHgA.copyable-area > div.DuUXI > div > div._1awRl.copyable-text.selectable-text"
  );

  for (let i = 0; i < 100; i++) {
    await inp.type("HI");
    await page.keyboard.press("Enter");
  }
}

scrape("https://web.whatsapp.com");
