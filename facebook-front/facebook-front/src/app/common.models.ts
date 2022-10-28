export interface PostInterface {
    id?: number;
    description: string;
    username: string;
    videoPath?: string;
    picturePath?: string;
    date?: string;
    likesDislikes?: LikeDislikeInterface[];
    commentsDTO?: Comment[];
}

export class Post implements PostInterface{
    id?: number;
    description: string;
    username: string;
    videoPath?: string;
    picturePath?: string;
    date?: string;
    likesDislikes?: LikeDislikeInterface[];
    comments?: Comment[];

    constructor(postCfg: PostInterface){
        this.id = postCfg.id;
        this.description = postCfg.description;
        this.username = postCfg.username;
        this.videoPath = postCfg.videoPath;
        this.picturePath = postCfg.picturePath;
        this.date = postCfg.date;
        this.likesDislikes = postCfg.likesDislikes;
        this.comments = postCfg.commentsDTO;
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