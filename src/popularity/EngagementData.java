package popularity;

public class EngagementData {

    private EngagementDLList<String> month;
    private EngagementDLList<String> username;
    private EngagementDLList<String> channelName;
    private EngagementDLList<String> country;
    private EngagementDLList<String> mainTopic;
    private EngagementDLList<String> likes;
    private EngagementDLList<String> posts;
    private EngagementDLList<String> followers;
    private EngagementDLList<String> comments;
    private EngagementDLList<String> views;

    public EngagementData() {
        month = new EngagementDLList<String>();
        username = new EngagementDLList<String>();
        country = new EngagementDLList<String>();
        mainTopic = new EngagementDLList<String>();
        likes = new EngagementDLList<String>();
        posts = new EngagementDLList<String>();
        followers = new EngagementDLList<String>();
        comments = new EngagementDLList<String>();
        views = new EngagementDLList<String>();
    }


    public EngagementDLList<String> getMonth() {
        return month;
    }


    public EngagementDLList<String> getUsername() {
        return username;
    }


    public EngagementDLList<String> getChannelName() {
        return channelName;
    }


    public EngagementDLList<String> getCountry() {
        return country;
    }


    public EngagementDLList<String> getMainTopic() {
        return mainTopic;
    }


    public EngagementDLList<String> getLikes() {
        return likes;
    }


    public EngagementDLList<String> getPosts() {
        return posts;
    }


    public EngagementDLList<String> getFollowers() {
        return followers;
    }


    public EngagementDLList<String> getComments() {
        return comments;
    }


    public EngagementDLList<String> getViews() {
        return views;
    }

}
