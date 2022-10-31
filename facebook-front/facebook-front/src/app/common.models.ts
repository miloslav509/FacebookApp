export interface PostInterface {
    id?: number;
    description: string;
    username: any;
    videoPath?: string;
    picturePath?: string;
    dateTime?: string;
    likesDislikes?: LikeDislikeInterface[];
    commentsDTO?: Comment[];
    views: number;
}

export class Post implements PostInterface{
    id?: number;
    description: string;
    username: any;
    videoPath?: string;
    picturePath?: string;
    dateTime?: string;
    likesDislikes?: LikeDislikeInterface[];
    comments?: Comment[];
    views: number;

    constructor(postCfg: PostInterface){
        this.id = postCfg.id;
        this.description = postCfg.description;
        this.username = postCfg.username;
        this.videoPath = postCfg.videoPath;
        this.picturePath = postCfg.picturePath;
        this.dateTime = postCfg.dateTime;
        this.likesDislikes = postCfg.likesDislikes;
        this.comments = postCfg.commentsDTO;
        this.views = postCfg.views;
    }
}

export interface CommentInterface {
    id?: number;
    username: string;
    description: string;
    date?: string;
    postId: number;
}

export interface LikeDislikeInterface {
    id?: number;
    type: string;
    postId: number;
    username: string;
}

export interface UserInterface {
    id?: number;
    username: string;
    password: string;
}

export enum Page {
    prev,
    next
}