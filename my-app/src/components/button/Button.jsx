import React from 'react';
import PropTypes from 'prop-types';
import './Button.css'

const propTypes = {
    caption: PropTypes.string,
    type: PropTypes.oneOf(['info','danger','sucess']),
};
const defaultProps = {
    onClick: Function.prototype
}

function Button(props){
        
    const className = `button-${props.types}`;
    const style = props.style;

    /** @param e {Event} */
    const handlesClick = e =>{
        e.preventDefault();
        e.stopPropagation();
        props.onClick();
    };
    
        return (
                <button className={className} onClick={handlesClick}>
                    {props.caption}
                </button>
        )
    

    
}
    
function CancelButton(props){
        
    const className = `button-${props.types}`;
    const style = props.style;

    /** @param e {Event} */
    const handlesClick = e =>{
        e.preventDefault();
        e.stopPropagation();
        props.onClick();
    };
    
        return (
                <button className={className} onClick={handlesClick}>
                    {props.caption}
                </button>
        )
    

    
}
   

Button.propTypes = propTypes;
//Button.defaultProps = defaultProps;
Button.cancel = CancelButton;
export default Button;