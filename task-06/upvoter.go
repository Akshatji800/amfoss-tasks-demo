package main

import (
	"context"
	"fmt"
	"log"

	"github.com/vartanbeno/go-reddit/reddit"
)

var ctx = context.Background()

func main() {
	if err := run(); err != nil {
		log.Fatal(err)
	}
}
func run() (err error) {
	withCredentials := reddit.WithCredentials("hHK0b*******REA", "UCu***vu_Zdo8z_******DXhgQ", "Ak*****i", "Ayu******800@")
	//here first input your "ID","SECRET","USERNAME","PASSWORD"
	client, _ := reddit.NewClient(withCredentials)
	sr, _, err := client.Subreddit.Get(ctx, "memes")
	if err != nil {
		return
	}

	fmt.Printf("%s was created on %s and has %d subscribers.\n", sr.NamePrefixed, sr.Created.Local(), sr.Subscribers)
	posts, _, err := client.Subreddit.TopPosts(ctx, "memes", &reddit.ListPostOptions{
		ListOptions: reddit.ListOptions{
			Limit: 100,
		},
		Time: "week",
	})
	if err != nil {
		return
	}

	for _, post := range posts {
		fmt.Println(post.Title)
		finalpostsid := "t3_" + post.ID
		_, err := client.Post.Upvote(context.Background(), finalpostsid)
		if err != nil {
			return err
		}
	}
	return
}
