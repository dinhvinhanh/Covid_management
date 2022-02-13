import  { useEffect } from "react";
import Resizer from "react-image-file-resizer";

function ImageResize(props) {
    const { imageToResize, onImageResized } = props;

    useEffect(() => {
        if (imageToResize) {
            const reader = new FileReader();
            reader.readAsDataURL(imageToResize);
        }
    }, [imageToResize]);

    useEffect(() => {
        if (imageToResize) {
            Resizer.imageFileResizer(
                imageToResize,
                500 ,
                500,
                "JPEG",
                100,
                0,
                (uri) => {
                    onImageResized(uri);
                },
                "base64",
                500,
                500
            );
        }
    }, [
        imageToResize,onImageResized
    ]);
    return''
}

ImageResize.defaultProps = {
    onImageResized: () => {},
};

export default ImageResize;
