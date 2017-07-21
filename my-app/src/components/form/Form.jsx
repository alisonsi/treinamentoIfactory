import React from 'react';
import PropTypes from 'prop-types';
import './Form.css'
function Form(props){
    const handleSubmit = e =>{
        e.preventDefault();
        e.stopPropation();
        props.onSubmit();
    }
        return (
            
            <form onSubmit={handleSubmit}>
                {props.children}
            </form>
        )
    
}

export default Form;